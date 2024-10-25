package InsertionSort;
import entities.*;
import  java.util.*;

/*дополнительно к основным сортировкам реализовать эти же алгоритмы сортировки таким образом,
что классы будут сортироваться по какому-либо числовому полю таким образом, что классы с четными
значениями будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах.*/

public interface InsertionSort <E extends Comparable<E>>{
    default void Sort(List<E> collection){
        System.out.println("Размер коллекции "+collection.size()+"\n");
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
        System.out.println("Min: "+ min + "\n");
    }
}

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
            System.out.println("\nСортировка в SpecialSort\n");
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
            for(T i:collection){
                System.out.println(i);
            }
            T temp=null;
            int left,i,j=1,k=0;
            for (left = idx.get(j); left < collection.size(); left=idx.get(++j)) {
                temp=collection.get(left);
                System.out.println("Temp="+temp);
                k=j-1;
                for (i=idx.get(k); (collection.get(i).compareTo(Objects.requireNonNull(temp))>0); i=idx.get(k)) {
                    System.out.println("(1)По индексу "+idx.get(k+1)+" хочу подставить "+collection.get(i)+"\n");
                    collection.set(idx.get(k+1),collection.get(i));
                    --k;
                    //if(k<0){break;}
                }
                System.out.println("(2)По индексу "+idx.get(k+1)+" хочу подставить "+temp+"\n");
                collection.set(idx.get(k+1),temp);
                if(j>=(idx.size()-1)){break;}
            }
            k=1;
            for(i=idx.get(k); i<collection.size()&&collection.get(i).compareTo(Objects.requireNonNull(first))<0; i=idx.get(k)){
                //if(k>=(idx.size())){break;}
                System.out.println("(3)По индексу "+idx.get(k-1)+" хочу подставить "+collection.get(i)+"\n");
                collection.set(idx.get(k-1),collection.get(i));
                ++k;
                if(k>=(idx.size())){break;}
            }
            System.out.println("(4)По индексу "+idx.get(k-1)+" хочу подставить "+first+"\n");
            collection.set(idx.get(k-1),first);

        }
    }

    public void SetMin(List<T> collection,T min, int index){
        for(int i=index+1;i<collection.size();++i){
            assert min != null;
            if ((collection.get(i).Gets()%2==0)&&(min.compareTo(collection.get(i))>0)){
                min=collection.get(i);
            }
        }
        collection.set(index,min);
        System.out.println("Min for SpecialSort: "+ min + "\n");
    }
}


class Main {
    public static void main(String[] args) {
        List<Human> test = new ArrayList<>();
        test.add(new Human.HumanBuilder("Female", "Anya", 28).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 26).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 24).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 32).build());
        test.add(new Human.HumanBuilder("Female", "Anya",20).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 27).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 25).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 17).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 15).build());
        test.add(new Human.HumanBuilder("Female", "Anya", 30).build());
        //Human.Sort(test);
        InsertionSort<Human> sort=new SpesialSort<Human>();
        sort.Sort(test);
        for(Human i:test){
            System.out.println(i);
        }

        }

//        List<Animal> test3 = new ArrayList<>();
//        test3.add(new Animal("Cat","blue",true));
//        test3.add(new Animal("Dog","black",true));
//        test3.add(new Animal("Pig","black",false));
//        test3.add(new Animal("Parrot","blue",false));


//        InsertionSort<Animal> test2=new AnimalSort(){
//            @Override
//            public void SpecialSort(List<Animal> collection) {
//                super.SpecialSort(collection);
//            }
//
//        };
//        test2.SpecialSort(test3);
//        for (Animal i : test3) {
//            System.out.println(i);
//        }
    }







