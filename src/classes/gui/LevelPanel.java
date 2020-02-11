package classes.gui;

import classes.board.MapLogic;
import classes.board.RectangularMap;
import classes.elements.IMapElement;
import classes.elements.Player;
import classes.stuff.MoveDirection;
import classes.stuff.Vector2d;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static classes.stuff.MoveDirection.*;
import static java.awt.event.KeyEvent.*;

public class LevelPanel extends JPanel {
    public RectangularMap map;
    private MapLogic logic;
    private Map<Vector2d, ElementTile> tilesMap;
    private int width;
    private int height;
    public Player player;
    private int tileSize = 50;
    private int resetTurns = 6;
    public MoveDirection lastMove = null;
    public MoveDirection oneMove = null;
    public MoveDirection lastEat = null;
    public MoveDirection oneEat = null;
    public Scoreboard scoreboard;
    private JSONArray rectMap = null;
    private BufferedImage image = null;
    private Game game;
    private Timer timer;
    private MoveBindings bindings;


    public LevelPanel(BufferedImage image, Game game) {
        this.game = game;
        this.image = image;
        this.map = new RectangularMap(image, this);
        constructPanel();
    }
    public LevelPanel(JSONArray rectMap, Game game) {
        this.game = game;
        this.rectMap = rectMap;
        this.map = new RectangularMap(rectMap, this);
        constructPanel();
    }

    private void constructPanel(){
        this.setBackground(new Color(255, 255, 255));
        this.logic = this.map.logic;
        this.player = this.map.player;
        this.tilesMap = new HashMap<>();
        this.width = Math.min(this.map.width, 16);
        this.height = Math.min(this.map.height, 10);
        setKeyBindings();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(tileSize*width, tileSize*height));

        this.scoreboard = new Scoreboard(this);
        this.scoreboard.setPreferredSize(new Dimension(2*tileSize, tileSize));

        initTiles();
        this.timer = new Timer(180, actionEvent -> {
            try {
                executeOneTurn();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void executeOneTurn() throws IOException {
        logic.explosionsOver();
        if(lastEat != null) {
            logic.eat(lastEat);
        } else if(oneEat != null) {
            logic.eat(oneEat);
        }
        if(lastMove != null) {
            logic.movePlayer(lastMove);
        } else if(oneMove != null) {
            logic.movePlayer(oneMove);
        }

        logic.moveElements();
        logic.explodeEveryDisc();
        updateTiles();
        oneEat = null;
        oneMove = null;
        if(logic.gameOver){
            resetTurns--;
            if(resetTurns < 0)
                resetLevel();
        }
        if(logic.gameWon) {
            this.game.getContentPane().removeAll();
            WinnerScreen winnerScreen = new WinnerScreen(this.game, this.player.points, this.scoreboard.totalPoints);
            this.game.add(winnerScreen);
            this.game.pack();
            this.game.setVisible(true);
            winnerScreen.requestFocusInWindow();
            this.timer.stop();
        }
    }

    public void initTiles(){
        this.removeAll();
        ElementTile tile;
        IMapElement ele;

        GridBagConstraints bag = new GridBagConstraints();
        bag.gridwidth = 1;
        bag.gridy = 0;

        int i;
        for(i=0; i<this.width/2-1;i++){
            ele = map.getElement(new Vector2d(Math.min(Math.max(0, player.getPosition().x-this.width/2), this.map.width - this.width)+i, Math.min(Math.max(0, player.getPosition().y-this.height/2), this.map.height - this.height)));
            tile = new ElementTile(ele.getImage());
            bag.gridx = i;
            this.add(tile, bag);
            this.tilesMap.put(new Vector2d(i,0), tile);
        }
        GridBagConstraints textBag = new GridBagConstraints();
        textBag.gridx = i;
        textBag.gridy = 0;
        textBag.gridwidth = 2;
        this.add(scoreboard, textBag);

        for(i=this.width/2+1; i<this.width;i++){
            ele = map.getElement(new Vector2d(Math.min(Math.max(0, player.getPosition().x-this.width/2), this.map.width - this.width)+i, Math.min(Math.max(0, player.getPosition().y-this.height/2), this.map.height - this.height)));
            tile = new ElementTile(ele.getImage());
            bag.gridx = i;
            this.add(tile, bag);
            this.tilesMap.put(new Vector2d(i,0), tile);
        }
        for(int j=1; j<height;j++){
            bag.gridy = j;
            for(i=0; i<width; i++){
                ele = map.getElement(new Vector2d(Math.min(Math.max(0, player.getPosition().x-this.width/2), this.map.width - this.width)+i, Math.min(Math.max(0, player.getPosition().y-this.height/2), this.map.height - this.height)+j));
                tile = new ElementTile(ele.getImage());
                bag.gridx = i;
                this.add(tile, bag);
                this.tilesMap.put(new Vector2d(i,j), tile);
            }
        }
    }

    private void updateTiles(){
        IMapElement ele;
        for(int j=0; j<height;j++){
            for(int i=0; i<width; i++){
                if(j != 0 || (i != this.width/2-1 && i != this.width/2)){
                    ele = map.getElement(new Vector2d(Math.min(Math.max(0, player.getPosition().x - this.width / 2), this.map.width - this.width) + i, Math.min(Math.max(0, player.getPosition().y - this.height / 2), this.map.height - this.height) + j));
                    this.tilesMap.get(new Vector2d(i, j)).changeImage(ele.getImage());
                }
            }
        }
    }

    private void resetLevel(){
        if(this.rectMap != null) {
            this.map = new RectangularMap(this.rectMap, this);
        }
        if (this.image != null) {
            this.map = new RectangularMap(this.image, this);
        }
        this.logic = map.logic;
        this.player = map.player;
        this.resetTurns = 6;
        updateTiles();
        this.scoreboard.updateText();
    }


    private void setKeyBindings(){
        this.setFocusable(true);
        this.bindings = new MoveBindings(this);
        this.addKeyListener(this.bindings);
        InputMap inputMap = getInputMap(WHEN_FOCUSED);
        ActionMap actionMap = getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("R"), "Reset");
        actionMap.put("Reset", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetLevel();
            }
        });
    }
}
