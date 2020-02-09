package classes.stuff;

public enum MoveDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Vector2d toUnitVector(){
        switch(this){
            case NORTH:
                return new Vector2d(0,-1);
            case EAST:
                return new Vector2d(1,0);
            case SOUTH:
                return new Vector2d(0,1);
            case WEST:
                return new Vector2d(-1,0);
        }
        return null;
    }

    @Override
    public String toString(){
        switch(this){
            case NORTH:
                return "up";
            case EAST:
                return "right";
            case SOUTH:
                return "down";
            case WEST:
                return "left";
        }
        return null;
    }
}
