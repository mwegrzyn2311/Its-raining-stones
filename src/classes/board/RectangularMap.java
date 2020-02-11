package classes.board;

import classes.elements.*;
import classes.gui.LevelPanel;
import classes.stuff.MoveDirection;
import classes.stuff.Vector2d;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class RectangularMap{
    public IMapElement[][] elements;
    public int width;
    public int height;
    public Player player;
    public MapLogic logic;
    public LevelPanel levelPanel;
    public int totalPoints;
    public SortedSet<IMapElement> movableElements = new TreeSet<>(new Comparator<IMapElement>(){
        @Override
        public int compare(IMapElement e1, IMapElement e2) {
            Vector2d v1 = e1.getPosition();
            Vector2d v2 = e2.getPosition();
            if(v1.y < v2.y){
                return 1; // y is lower, so it is higher
            }else if(v1.y > v2.y){
                return -1;
            }else{
                if(v1.x > v2.x)
                    return 1;
                else if(v1.x < v2.x)
                    return -1;
                else
                    return 0;
            }
        }
    });

    public RectangularMap(JSONArray map, LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
        this.logic = new MapLogic(this);
        totalPoints = 0;
        this.height = map.length();
        this.width = map.getJSONArray(0).length();
        elements = new IMapElement[this.width][this.height];
        for (int i = this.height-1; i >= 0 ; i--) {
            JSONArray rows = map.getJSONArray(i);
            for (int j = 0; j < this.width; j++) {
                String curr = rows.getString(j);
                switch (curr) {
                    case ("D"):
                        elements[j][i] = new Disc(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        break;
                    case ("E"):
                        elements[j][i] = new Empty(new Vector2d(j, i));
                        break;
                    case ("X"):
                        elements[j][i] = new Exit(new Vector2d(j, i));
                        break;
                    case ("P"):
                        elements[j][i] = new GamePoint(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        this.totalPoints++;
                        break;
                    case ("G"):
                        elements[j][i] = new Grass(new Vector2d(j, i));
                        break;
                    case ("O"):
                        this.player = new Player(new Vector2d(j, i), this);
                        elements[j][i] = this.player;
                        break;
                    case ("R"):
                        elements[j][i] = new Rock(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        break;
                    case ("S"):
                        elements[j][i] = new SolidWall(new Vector2d(j, i));
                        break;
                    case("T"):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.EAST);
                        break;
                    case("N"):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.NORTH);
                        break;
                    case("Z"):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.WEST);
                        break;
                    case("V"):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.SOUTH);
                        break;
                    case ("W"):
                        elements[j][i] = new Wall(new Vector2d(j, i));
                        break;
                    default:
                        throw new IllegalArgumentException("Argument " + curr + " does not correspond to any existing element");
                }
            }
            for (int j = 0; j < this.width; j++){
                if(elements[j][i].isMovable())
                    this.logic.startMovingPushedElement(new Vector2d(j,i));
            }
        }
    }

    public RectangularMap(BufferedImage image, LevelPanel levelPanel) {
        this.levelPanel = levelPanel;
        this.logic = new MapLogic(this);
        totalPoints = 0;
        this.width = image.getWidth();
        this.height = image.getHeight();
        elements = new IMapElement[this.width][this.height];
        for (int i = this.height-1; i >= 0 ; i--) {
            for (int j = 0; j < this.width; j++) {
                int clr = image.getRGB(j,i);
                switch (clr) {
                    case (-7864293):
                        elements[j][i] = new Disc(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        break;
                    case (-3947581):
                    case(-1):
                        elements[j][i] = new Empty(new Vector2d(j, i));
                        break;
                    case (-16733965):
                        elements[j][i] = new Exit(new Vector2d(j, i));
                        break;
                    case (-4702790):
                        elements[j][i] = new GamePoint(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        this.totalPoints++;
                        break;
                    case (-3866866):
                        elements[j][i] = new Grass(new Vector2d(j, i));
                        break;
                    case (-32985):
                        this.player = new Player(new Vector2d(j, i), this);
                        elements[j][i] = this.player;
                        break;
                    case (-4621738):
                        elements[j][i] = new Rock(new Vector2d(j, i));
                        this.movableElements.add(elements[j][i]);
                        break;
                    case (-16777216):
                        elements[j][i] = new SolidWall(new Vector2d(j, i));
                        break;
                    case(-3584):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.EAST);
                        break;
                    case(-20792):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.NORTH);
                        break;
                    case(-15806139):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.WEST);
                        break;
                    case(-136026):
                        elements[j][i] = new Tunnel(new Vector2d(j,i), MoveDirection.SOUTH);
                        break;
                    case (-10987432):
                        elements[j][i] = new Wall(new Vector2d(j, i));
                        break;
                    default:
                        throw new IllegalArgumentException("Argument " + clr + " at " + new Vector2d(j,i) + " does not correspond to any existing element");
                }
            }
            for (int j = 0; j < this.width; j++){
                if(elements[j][i].isMovable())
                    this.logic.startMovingPushedElement(new Vector2d(j,i));
            }
        }
    }



    public void setElement(Vector2d position, IMapElement ele){
        ele.setPosition(position);
        this.elements[position.x][position.y] = ele;
    }

    public boolean canMoveTo(Vector2d position){
        if(!isInMap(position))
            return false;
        IMapElement ele = getElement(position);
        return(ele instanceof Empty || ele instanceof Grass || ele instanceof GamePoint || ele instanceof Exit);
    }

    public boolean canPushAt(Vector2d position, MoveDirection dir){
        if(!isMovableElement(position) || getElement(position) instanceof GamePoint || getElement(position).isFalling())
            return false;
        Vector2d destination = position.add(dir.toUnitVector());
        return getElement(destination) instanceof Empty;
    }

    public boolean isInMap(Vector2d position){
        return position.precedes(new Vector2d(this.width-1, this.height-1)) && position.follows(new Vector2d(0,0));
    }

    public IMapElement getElement(Vector2d position){
        if(!isInMap(position)) {
            System.out.println("Who the hell are you? "+position);
            return null;
        }
        return this.elements[position.x][position.y];
    }

    public boolean isMovableElement(Vector2d position){
        if(!isInMap(position))
            return false;
        else
            return(getElement(position).isMovable());
    }

    public boolean stopsMovingElement(Vector2d position){
        if(!isInMap(position))
            return true;
        IMapElement ele = getElement(position);
        return(!ele.isMovable() && !(ele instanceof Empty) && !(ele instanceof Explosion) && !(ele instanceof Player));
    }

    public Vector2d getPlayerPosition(){
        return this.player.getPosition();
    }
}
