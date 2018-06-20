package extStruct;

public class TestMap {
    public static void main(String[] args){
        ExtHashMap<String,Object> map = new ExtHashMap();
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);
        map.put("4",1);
        map.put("5",1);
        map.put("6",1);
        map.put("7",1);
        map.put("14",1);
        map.put("3",123);
        map.print();


    }

}
