package homework.lesson2.ExeptionProject;

class MyArray {

    private int sum = 0;
    String[][] str;

    public MyArray(String[][] str) throws MyArraySizeException{
        if(str.length != 4){
            throw new MyArraySizeException("Число строк массива должно быть 4!");
        }
        for (int i = 0; i < str.length; i++){
            if(str[i].length != 4){
                throw new MyArraySizeException("Число элементов массива не равно 4 в строке №" + i);
            }
        }
        this.str = str;
    }

    public int calcSumOfElements  () throws MyArrayDataException{
        for (int i = 0; i < str.length; i++){
            for (int j = 0; j < str[i].length; j++){
                try {
                    sum += Integer.parseInt(str[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException("Элемент " + "[" + i + "]" + "[" + j + "]" +
                            " массива не является числом!");
                }
            }
        }
        return sum;
    }
}
