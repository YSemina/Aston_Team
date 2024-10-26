package InsertionSort;
import entities.*;
import  java.util.*;

/*дополнительно к основным сортировкам реализовать эти же алгоритмы сортировки таким образом,
что классы будут сортироваться по какому-либо числовому полю таким образом, что классы с четными
значениями будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах.*/

public interface InsertionSort <E extends Comparable<E>>{
    default void Sort(List<E> collection){
        E first=collection.get(0);
        setMin(collection);
        E temp;
        int left,i;
        for (left = 1; left < collection.size(); ++left) {
            temp=collection.get(left);
            for (i=left-1; collection.get(i).compareTo(temp)>0; --i) {
                collection.set(i+1,collection.get(i));
            }
            collection.set(i+1,temp);
        }
        for(i=1;i<collection.size()&&collection.get(i).compareTo(first)<0;++i){
            collection.set(i-1,collection.get(i));
        }
        collection.set(i-1,first);
    }

    default void setMin(List<E> collection){
        E min=collection.get(0);
        for(int i=1;i<collection.size();++i){
            if (min.compareTo(collection.get(i))>0){
                min=collection.get(i);
            }
        }
        collection.set(0,min);
    }
}
 //это натуральная сортировка для четных числовых полей
class SpesialSort<T extends Get & Comparable<T>> implements InsertionSort<T>{

    @Override
    public void Sort(List<T> collection){

        int count=0;//счетчик

        for (T i : collection) {
            if (i.Gets() % 2 == 0) {
                ++count;
            }
        }
        if(count==0){
            System.out.println("Увы, в этом списке нет объектов с четным числовым полем.\nСортировки не будет.\n");
        }
        else if(count==1){
            System.out.println("В этом списке лишь один объект с четным числовым полем.\nВ сортировке нет смысла.\n");
        }
        else{
            //список для хранения индексов, под которыми находятся элементы с четными числовыми полями
            ArrayList<Integer> idx=new ArrayList<>();
            //добавляю в список все индексы
            for(int i=0;i<collection.size();++i){
                if(collection.get(i).Gets()%2==0){
                    idx.add(i);
                }
            }
            T first=null;
            //в переменную сохраняю первый объект, удовлетворяющий поиску
            for (T t : collection) {
                if (t.Gets() % 2 == 0) {
                    first = t;
                    break;
                }
            }
            //установка минимального значение в начало сортировки
            SetMin(collection,first,idx.get(0));
            T temp=null;
            int left,i,j=1,k=0;
            for (left = idx.get(j); left < collection.size(); left=idx.get(++j)) {
                temp=collection.get(left);
                k=j-1;
                for (i=idx.get(k); (collection.get(i).compareTo(Objects.requireNonNull(temp))>0); i=idx.get(k)) {
                    collection.set(idx.get(k+1),collection.get(i));
                    --k;
                }
                collection.set(idx.get(k+1),temp);
                if(j>=(idx.size()-1)){break;}
            }
            k=1;
            for(i=idx.get(k); i<collection.size()&&collection.get(i).compareTo(Objects.requireNonNull(first))<0; i=idx.get(k)){
                collection.set(idx.get(k-1),collection.get(i));
                ++k;
                if(k>=(idx.size())){break;}
            }
            collection.set((idx.get(k-1)),first);
        }
    }

    public void SetMin(List<T> collection,T min, int index){
        for(int i=index+1;i<collection.size();++i){
            assert min != null;
            //если числовое поле - четное
            if ((collection.get(i).Gets()%2==0)&&(min.compareTo(collection.get(i))>0)){
                min=collection.get(i);
            }
        }
        collection.set(index,min);
    }
}
//это сортировка для четных числовых полей по числовому полю
class SpesialSort2<T extends Get & Comparable<T>> implements InsertionSort<T>,Comparator<T>{
    @Override
    public int compare(T h1, T h2) {
        return h1.Gets()-h2.Gets();
    }
    @Override
    public void Sort(List<T> collection){

        int count=0;//счетчик

        for (T i : collection) {
            if (i.Gets() % 2 == 0) {
                ++count;
            }
        }
        if(count==0){
            System.out.println("Увы, в этом списке нет объектов с четным числовым полем.\nСортировки не будет.\n");
        }
        else if(count==1){
            System.out.println("В этом списке лишь один объект с четным числовым полем.\nВ сортировке нет смысла.\n");
        }
        else{
            ArrayList<Integer> idx=new ArrayList<>();
            for(int i=0;i<collection.size();++i){
                if(collection.get(i).Gets()%2==0){
                    idx.add(i);
                }
            }
            T first=null;
            for (T t : collection) {
                if (t.Gets() % 2 == 0) {
                    first = t;
                    break;
                }
            }
            SetMin(collection,first,idx.get(0));
            T temp=null;
            int left,i,j=1,k=0;
            for (left = idx.get(j); left < collection.size(); left=idx.get(++j)) {
                temp=collection.get(left);
                k=j-1;
                for (i=idx.get(k); (compare(collection.get(i),temp)>0); i=idx.get(k)) {
                    collection.set(idx.get(k+1),collection.get(i));
                    --k;
                }
                collection.set(idx.get(k+1),temp);
                if(j>=(idx.size()-1)){break;}
            }
            k=1;
            for(i=idx.get(k); i<collection.size()&&compare(collection.get(i),first)<0; i=idx.get(k)){
                collection.set(idx.get(k-1),collection.get(i));
                ++k;
                if(k>=(idx.size())){break;}
            }
            collection.set((idx.get(k-1)),first);
        }
    }

    public void SetMin(List<T> collection,T min, int index){
        for(int i=index+1;i<collection.size();++i){
            assert min != null;
            if ((collection.get(i).Gets()%2==0)&&(compare(min,collection.get(i))>0)){
                min=collection.get(i);
            }
        }
        collection.set(index,min);
    }
}


class Main {
    public static void main(String[] args) {
        List<Human> test = new ArrayList<>();
        test.add(new Human.HumanBuilder("Female", "Anya", 28).build());
        test.add(new Human.HumanBuilder("Female", "Lena", 26).build());
        test.add(new Human.HumanBuilder("Female", "Olga", 24).build());
        test.add(new Human.HumanBuilder("Female", "Bella", 32).build());
        test.add(new Human.HumanBuilder("Female", "Danna",20).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 27).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 25).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 17).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 15).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 30).build());
        InsertionSort<Human> sort=new SpesialSort2<Human>();
        sort.Sort(test);
        System.out.println("\nСортировка по числовому полю для четных значений:\n");
        for(Human i:test){
            System.out.println(i);
        }
        InsertionSort<Human> sort2=new SpesialSort<Human>();
        sort2.Sort(test);
        System.out.println("\nНатуральная сортировка для четных числовых полей:\n");
        for(Human i:test){
            System.out.println(i);
        }
        Human.Sort(test);
        System.out.println("\nНатуральная сортировка:\n");
        for(Human i:test){
            System.out.println(i);
        }
        }
    }







