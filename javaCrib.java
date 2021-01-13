package mypackage;

import java.util.*;

public class javaCrib {
    public static void main(String[] args) {

        // типы данных
        byte tempByte = 1;   // не юзают
        short tempShort = 1; // не юзают
        int tempInt = 1;     // норм
        long tempLong = 1;   // если не хватает int`a
        float tempFloat = 1; // дробь, но лучше юзать дабл
        double tempDouble = 1.2; // норм дробь
        char tempChar = '1'; // только один символ
        boolean tempBoolean = true; // true или false
        String str = "Hello world"; // строка

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Массивы
        String[] strArr = new String[3]; // пример обьявления массива
        strArr[1] = "hello"; // пример заполнения массива
        String[] tempStrArr = {"h", "e", "l", "l", "o"};

        int[] intArr = new int[0];
        int[][] twoArray = new int[5][5]; // двухмерный массив (матрица)
        Arrays.toString(strArr); // преобразует массив в одну строку
        Arrays.sort(strArr, 0, 3); // сортирует массив "strArr" по индексу "от" и "до"
        Arrays.binarySearch(tempStrArr, "e"); // ищёт в массиве "e" и в результате выведет его индекс, или -1 если этого ключа нету в массиве

        for (int i = 0; i < 5; i++){
            System.out.println(tempStrArr[i]);
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // Простые операции и логические операторы
        /*
        +
        -
        *
        /
        %
        <
        >
        <=
        >=
        ==
        !=
        i++
        i--
        ++i
        --i
        +=
        -=
        *=
        /=
        %=
        || или
        && and
        Math.sqrt(a) корень квадратный от числа "a"
        Math.pov(a, 4) "a" в 4й степени
         */
        System.out.println(!(false)); // true

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // Подробнее о string
        String str1 = "Hello";
        String str2 = "World";
        String str3;

        str3 = str1 + str2; // HelloWorld
        str3 = str2.concat(str1); //HelloWorld
        str3 = String.join(" ", str1, str2); // Hello World

        str1.charAt(2); // выведет "l"
        str1.indexOf("l"); // выведет "2" (первый найденный символ "l")
        str1.lastIndexOf("l"); // выедет "3" (последний найденный сивмол "l")

        char[] charArr = new char[0];
        str1.getChars(1, 3, charArr, 0); // получить символы начиная от(srcBegin) до(srcEnd) вывести в (charArr) начиная с индекса(dstBegin)

        str1.equals("hello");  // равно ли "str" строке
        str1.equalsIgnoreCase("hello");
        str1.startsWith("He"); // true
        str1.endsWith("lo"); // true
        str1.replace("Hello", "Bye"); // str1.equal("Bye") - true
        str1.trim(); // удаляет начальные и конечные пробелы
        str1.substring(6); // вернёт всё, что начинаеться с 6го индекса
        str1.substring(1, 5); // вернёт всё, что в промежутке с 1го по 6й индекс
        str1.toLowerCase();
        str2.toUpperCase();

        str1.split(" "); // разбивает строку на массив убирая выбранный символ
        str1 = "Hello world. I am Adrian";
        String[] words = str1.split(" "); // words выглядит так: {"Hello", "world.", "I", "am", "Adrian"}

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // Условия и множественный выбор
        int i1 = 2;
        if ( i1 > 5) {
            System.out.println("if");
        } else if ( i1 < 0 ) {
            System.out.println("Else If");
        } else {
            System.out.println("else");
        }

        int i2 = 3;
        switch (i2){    // берёт значение i2 и сравнивает с кейсами. Вощле кейса стоит значение, если i2 = этому значению, то этот кейс выполняеться, в противном случае выполниться default
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println("default");
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // циклы
        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        };

        int[] array1 = {1, 2, 3, 4, 5};

        for (int element : array1) {       // выведет все елементы массива array1
            System.out.println(element);
        };

        int j = 0;
        while(j < 10){
            System.out.println();
        };

        do {
            System.out.println("hoba");
        } while ( j < 10 );

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // List  --- коллекция элементов
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(10000);

        System.out.println(list.get(1));

        list.set(1, 100);

        list.remove(1);
        System.out.println(list.get(1));

        System.out.println(list.size());

        list.clear();

        List<Integer> list2 = new ArrayList<>();
        list2.add(46);

        list2.addAll(list);
        list2.removeAll(list);

        System.out.println(list.isEmpty());

        System.out.println(list.contains(100));

        list.containsAll(list2);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // Iterator
        Iterator<Integer> iterator = list.iterator();
        //System.out.println(iterator.next());
        //System.out.println(iterator.hasNext());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        };

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        // set  - множество уникальных элементов. почти также как и list
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.remove(1); Map<Integer, String> map = new HashMap();
        set.size();
        set.clear();
        set.contains(1);


        Iterator<Integer> iterator2 = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        };

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        // map -- хранит данные по (ключ, значение)

        Map<Integer, String> map = new HashMap();
        map.put(1, "hey");
        map.get(1);
        map.size();
        map.clear();

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        // методы (проще говоря - функции)

      //  static int getSum(int x, int y){
     //       int sum;
     //       sum = x + y;
     //       return sum;
     //   }

            // перегрузка методов
            //Если метод просит 3 перемнных, можно отправить просто 2 переменных. Если не указать переменных ошибок не будет

            //Исключения
//            try {
//                System.out.println("Result is:" + a/b);
//            } catch (ArithmeticException e){    // если арифметическая ошибка, ТО
//                System.out.println("Problem");
//            }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Классы и обьекты

        //класс это отдельный файл. Название всегда с большой буквы
        //последующий код нужно писать в отдельном доке(новый класс)



//        package mypackage;
//
//        public class Car {
//            public Car(){   // если при вызове класса скобки пустые, то ->
//                System.out.println("New Car Created!");
//            }
//
//            public Car(int weight){  // если при вызове класса в скобки ввести цифру, то ->
//                this.weight = weight;
//            }
//
//            int height;
//            int weight;
//
//            public void addWeight(int weight){
//                this.weight += weight;
//            }
//        }



        // Вызов этого класса в другом классе:
//        Car car1 = new Car();
//        car1.weight = 10;

        //конструктор класса - для того чтобы при обьявлении класса, сразу ввести в него переменные (Описанно выше)

        //модификаторы static и final (для класса)
        //если создать переменну вот так: static int var = 100; она будет во всех переменных клсаа
        //и вызывать её можно сразу,не обьявляя класс

        //используеться больше для методов, чтобы при вызове класса, можно было вызывать методы для него

        //final используеться для создания констант

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // ООП

        //Наследование:

//        package mypackage;
//
//        public class Animal {
//            String name;
//            String color;
//
//            public void sleep(){
//                System.out.println("Zzz");
//            }
//        }
//        //
//        package mypackage;
//
//        public class Dog extends Animal {
//            public void sit(){
//                System.out.println("Dog is sitting");
//            }
//        }

        // extends - наследования всего из другого класса

        ///////////////////////////////////////////////////////////

        // Инкапсуляция
        //Модификаторы доступа: для обьявления переменной нужно вначале добавить privat
        //геттеры и сеттеры (ALt + Insert)

        // Полиморфизм
        //В класс для которго хотим изменить наслодоавнный метод нужно написать
        //@Override + метод уже измененный

        //абстрактные классы и методы (чтобы обьявить методы для всех, но сделать их путыми и для того, чтобы унаследовать класс нужно их нужно заполнить)
        // чтобы обьявить такой нужно написать при обьявлении класса abstract
        //public abstaract class ...
        //public abstract void ...

        // Интерфейсы - создание методов без тела, чтобы обьявить их потом
        // вызов при создании нового клсса вписать implements (Через запятую можно сразу несколько)
        // public class Plane implemets Transport;   // Trasport - это класс интерфейс, у которого только пустые методы готовые для заполнения



        //////////////////////
// DATABASE

        @Test
        public void test() throws SQLException, ClassNotFoundException {
            //test("113", "Dispatched");

            Connection connection = null;
            Statement statement = null;

            System.out.println("Registering JDBC driver...");

            Class.forName("org.postgresql.Driver");

            System.out.println("Creating database connection...");
            connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.USER_DB, DBConstant.PASS_DB);

            System.out.println("Executing statement...");
            statement = connection.createStatement();

            String sql1, sql2;
            //sql1 = "SELECT * FROM loads.load WHERE load_id = 113";
            sql2 = "UPDATE loads.load SET status = 'Prebooked' WHERE load_id = 113";

            //ResultSet resultSet = statement.executeQuery(sql1);
            ResultSet resultSet1 = statement.executeQuery(sql2);

//
//        System.out.println("Retrieving data from database...");
//        System.out.println("\nLoads:");
//        while (resultSet.next()) {
//            int id = resultSet.getInt("load_id");
//            String name = resultSet.getString("status");
//            String specialty = resultSet.getString("comments");
//
//            System.out.println("\n================\n");
//            System.out.println("id: " + id);
//            System.out.println("Name: " + name);
//            System.out.println("Specialty: " + specialty);
//        }



            System.out.println("Closing connection and releasing resources...");
            //resultSet.close();
            resultSet1.close();
            statement.close();
            connection.close();
        }

    }
}
