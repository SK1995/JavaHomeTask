package main;
/**
 * Created by Данил on 06.03.2016.
 */
public class Key {

    private boolean isBadKey;
    private int keyID;
    public Key(int i, boolean isBadKey)
    {
        keyID=i;
        this.isBadKey=isBadKey;
    }

    @Override  public int hashCode()
    {
        if (isBadKey)//Плохой ключ - хэширование в одну ячейку
            return 0;
        else
             return Integer.toString(keyID).hashCode();
    }

    @Override public boolean equals(Object another){
        if(this.getClass() != another.getClass()){
            return false;
        }
        return (this.keyID == ((Key) another).keyID);
    }
}
