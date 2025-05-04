import java.util.*;

/**
* Выполняю второе задание из дз по логированию перехода из связанного списка в бинарное дерево. Для выполнения задания нужно было выводить: 1) общий размер мапы, 2) размер односвязного списка и 3) тип ноды
 * 1) легко
 * 2) не смог найти как можно получить односвязный список из бакета.
 * 3) не понимаю как можно получить тип ноды, ведь он запривачен.
* */

public class Main {
    public static void main(String[] args) {

        /**
        * Создаю несколько объектов и помещаю их в мапу Haschmap
        * */

        Word doge = new Word("doge");
        Word chair = new Word("chair");
        Word duck = new Word("duck");

        HashMap map = new HashMap();
        map.put(doge, 1);
        map.put(chair, 2);
        map.put(duck, 3);
        map.put(new Word("data"), 4);
        map.put(new Word("duty"), 5);
        map.put(new Word("disco"), 6);

        System.out.println(map.get(duck));
        /*LinkedList<Word> l = (LinkedList<Word>) map.get(duck); //моя попытка получить LinkedList элементов, созданного коллизией. .get(Word) возвращает лишь 1 элемент по ключу Word, а не список. Не знаю как получить список.
        ListIterator<Word> iter = l.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }*/


        Map.Entry<Word, Integer> firstEntry = (Map.Entry<Word, Integer>) map.entrySet().iterator().next();
        System.out.println(firstEntry);

        //System.out.println(map.getNode(duck)); // getNode(java.lang.Object) is not public in java.util.HashMap

        /*Map.Entry<Word, Integer> lastEntry = null; // моя попытка взаимодействовать с HashMap, как с LinkedHashMap. Первый элемент получилось достать, но  перебор для взятия последнего выдаёт ошибку
        for (Map.Entry<Word, Integer> entry :  map.entrySet()) {
            lastEntry = entry;
        }
        System.out.println(lastEntry);*/



        /**
        * Перехожу порог в 8 элементов, чтобы увидеть изменения. Изменений не видно потому что я не знаю как достать Node (она запривачена)
        * */

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(duck) + " || " + Arrays.asList(map) + " || Размер списка ключей: " + map.keySet().size() + ". Весь список ключей: "  + map.keySet());

        map.put(new Word("dron"), 7);

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(doge) + " || " + Arrays.asList(map) + " || Размер списка ключей: " + map.keySet().size() + ". Весь список ключей: "  + map.keySet());

        map.put(new Word("dog"), 8);

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(doge) + " || " + Arrays.asList(map) + " || Размер списка ключей: " + map.keySet().size() + ". Весь список ключей: "  + map.keySet());

        map.put(new Word("doll"), 9);

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(doge) + " || " + Arrays.asList(map) + " || Размер списка ключей: " + map.keySet().size() + ". Весь список ключей: "  + map.keySet());

        map.put(new Word("dragon"), 10);

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(doge) + " || " + Arrays.asList(map) + " || Размер списка ключей: " + map.keySet().size() + ". Весь список ключей: "  + map.keySet());

        System.out.println("Значение doge: " + map.get(new Word("doge")));
        System.out.println("Значение chair: " + map.get(new Word("chair")));
        System.out.println("Значение duck: " + map.get(new Word("duck")));
        System.out.println("Значение disco: " + map.get(new Word("disco")));
        System.out.println();


        System.out.println("Значение doge " + map.get(new Word("doge")));

        Set<Map.Entry> entrySet = map.entrySet();

        for (Map.Entry pair : entrySet){
            if (duck.equals(pair.getValue())){
                System.out.println(pair.getValue());
            }
        }

        /*
        * Моя первая попытка работы с HashMap. Тип объекта integer путал меня, поэтому я всё переделал под тип String.
        *
        * Создаю итератор для вывода всех значений мапы
        * */

        /*Iterator<Map.Entry<Product, Integer>> iter =map.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.println();
            System.out.print(iter.next());
            }

        *//*
        * Через петлю добавляю ещё 5 значений и вывожу их итератором
        * *//*

        for (int i = 0; i < 5; i++){
            Product text = new Product(i);
            map.put(text, 1);
            System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(cheese) + " || " + Arrays.asList(map) );
        }

        System.out.println("Размер мапы: " + map.size() + ". Объект 1: " + map.get(cheese) + " || " + Arrays.asList(map) );


        Iterator<Map.Entry<Product, Integer>> itera =map.entrySet().iterator();
        while (itera.hasNext()) {
            System.out.println();
            System.out.print(itera.next());
        }*/
            
    }
}

/**
* Создаю свой класс в котором переопределяю методы equals и hashCode, нарушая контракт.
* */
class Word {
    String word;

    Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word other = (Word) obj;
        return Objects.equals(word, other.word); // true
    }

    @Override
    public int hashCode() {
        /*int hash = (int)word.charAt(0);
        System.out.println("хэшкод для ключа: " + word + " = " + hash);*/  //код написанный, для выделения одинакого кэша словам, начинающимся с одной буквы
        return 22; // упрощение, выдаю всем словам одинаковый кэш
    }
}