package classes.gui;

import classes.stuff.MoveDirection;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveBindings implements KeyListener {
    private LevelPanel levelPanel;
    public boolean upPressed=false;
    public boolean rightPressed=false;
    public boolean downPressed=false;
    public boolean leftPressed=false;

    private boolean upEat=false;
    private boolean rightEat=false;
    private boolean downEat=false;
    private boolean leftEat=false;

    public MoveBindings(LevelPanel levelPanel){
        this.levelPanel = levelPanel;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()){
            // Firstly moving player
            case(KeyEvent.VK_UP):
                upPressed = true;
                this.levelPanel.lastMove = MoveDirection.NORTH;
                this.levelPanel.oneMove = MoveDirection.NORTH;
                break;
            case(KeyEvent.VK_RIGHT):
                rightPressed = true;
                this.levelPanel.lastMove = MoveDirection.EAST;
                this.levelPanel.oneMove = MoveDirection.EAST;
                break;
            case(KeyEvent.VK_DOWN):
                downPressed = true;
                this.levelPanel.lastMove = MoveDirection.SOUTH;
                this.levelPanel.oneMove = MoveDirection.SOUTH;
                break;
            case(KeyEvent.VK_LEFT):
                leftPressed = true;
                this.levelPanel.lastMove = MoveDirection.WEST;
                this.levelPanel.oneMove = MoveDirection.WEST;
                break;
            // Then eating
            case(KeyEvent.VK_W):
                upEat = true;
                this.levelPanel.lastEat = MoveDirection.NORTH;
                this.levelPanel.oneEat = MoveDirection.NORTH;
                break;
            case(KeyEvent.VK_D):
                rightEat = true;
                this.levelPanel.lastEat = MoveDirection.EAST;
                this.levelPanel.oneEat = MoveDirection.EAST;
                break;
            case(KeyEvent.VK_S):
                downEat = true;
                this.levelPanel.lastEat = MoveDirection.SOUTH;
                this.levelPanel.oneEat = MoveDirection.SOUTH;
                break;
            case(KeyEvent.VK_A):
                leftEat = true;
                this.levelPanel.lastEat = MoveDirection.WEST;
                this.levelPanel.oneEat = MoveDirection.WEST;
                break;
            default:
        }
        /*
        switch (keyEvent.getKeyCode()){
            // Firstly moving player
            case(KeyEvent.VK_W):
                upPressed = true;
                this.levelPanel.lastMove = MoveDirection.NORTH;
                this.levelPanel.oneMove = MoveDirection.NORTH;
                break;
            case(KeyEvent.VK_D):
                rightPressed = true;
                this.levelPanel.lastMove = MoveDirection.EAST;
                this.levelPanel.oneMove = MoveDirection.EAST;
                break;
            case(KeyEvent.VK_S):
                downPressed = true;
                this.levelPanel.lastMove = MoveDirection.SOUTH;
                this.levelPanel.oneMove = MoveDirection.SOUTH;
                break;
            case(KeyEvent.VK_A):
                leftPressed = true;
                this.levelPanel.lastMove = MoveDirection.WEST;
                this.levelPanel.oneMove = MoveDirection.WEST;
                break;
            // Then eating
            case(KeyEvent.VK_UP):
                upEat = true;
                this.levelPanel.lastEat = MoveDirection.NORTH;
                this.levelPanel.oneEat = MoveDirection.NORTH;
                break;
            case(KeyEvent.VK_RIGHT):
                rightEat = true;
                this.levelPanel.lastEat = MoveDirection.EAST;
                this.levelPanel.oneEat = MoveDirection.EAST;
                break;
            case(KeyEvent.VK_DOWN):
                downEat = true;
                this.levelPanel.lastEat = MoveDirection.SOUTH;
                this.levelPanel.oneEat = MoveDirection.SOUTH;
                break;
            case(KeyEvent.VK_LEFT):
                leftEat = true;
                this.levelPanel.lastEat = MoveDirection.WEST;
                this.levelPanel.oneEat = MoveDirection.WEST;
                break;
            default:
        }

         */
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        /*
        switch (keyEvent.getKeyCode()){

            // Firstly move
            case(KeyEvent.VK_W):
                upPressed = false;
                break;
            case(KeyEvent.VK_D):
                rightPressed = false;
                break;
            case(KeyEvent.VK_S):
                downPressed = false;
                break;
            case(KeyEvent.VK_A):
                leftPressed = false;
                break;
            // And then eat
            case(KeyEvent.VK_UP):
                upEat = false;
                break;
            case(KeyEvent.VK_RIGHT):
                rightEat = false;
                break;
            case(KeyEvent.VK_DOWN):
                downEat = false;
                break;
            case(KeyEvent.VK_LEFT):
                leftEat = false;
                break;
            default:
        }

         */
        switch (keyEvent.getKeyCode()){

            // Firstly move
            case(KeyEvent.VK_UP):
                upPressed = false;
                break;
            case(KeyEvent.VK_RIGHT):
                rightPressed = false;
                break;
            case(KeyEvent.VK_DOWN):
                downPressed = false;
                break;
            case(KeyEvent.VK_LEFT):
                leftPressed = false;
                break;
            // And then eat
            case(KeyEvent.VK_W):
                upEat = false;
                break;
            case(KeyEvent.VK_D):
                rightEat = false;
                break;
            case(KeyEvent.VK_S):
                downEat = false;
                break;
            case(KeyEvent.VK_A):
                leftEat = false;
                break;
            default:
        }

        if(!(upPressed || rightPressed || downPressed || leftPressed))
            this.levelPanel.lastMove = null;
        if(!(upEat || rightEat || downEat || leftEat))
            this.levelPanel.lastEat = null;
    }
}
