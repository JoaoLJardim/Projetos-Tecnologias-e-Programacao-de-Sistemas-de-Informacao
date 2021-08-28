public class Main {

    public static void main(String[] args) {
        Apartment apartment = new Apartment(Condition.NEW, 3000,2017,2,2000,new Garage(400,1,true), 1,true);
        System.out.println(apartment);

        House house = new House(Condition.NEW, 2000,2017,2,2000,new Garage(400,1,true), 1,false);
        System.out.println(house);

        System.out.println();
        PropertyList propertyList = new PropertyList();
        propertyList.addProperties(house);
        propertyList.addProperties(apartment);


        System.out.println(propertyList.toString());
        System.out.println();


        propertyList.sort();

        System.out.println(propertyList);


//        // America
//        System.out.println(exerciseSeven("C<A,I<C,R<I,E<R,M<E,A<M"));
//
//        // Africa
//        System.out.println(exerciseSevenBack("A<F,F<R,R<I,I<C,C<A"));
    }

    // Africa
    public static String exerciseSevenBack(String str) {
        String[] strings = str.split(",");

        String result = "";

        for (int i = strings.length -1; i >= 0; i--) {
            String[] strings1 = strings[i].split("<");
            if (result.equals("")) {
                result = strings1[0] + strings1[1];
            } else {
                if (result.indexOf(strings1[1]) != 0) {
                    result = result + strings1[0];
                } else if (result.indexOf(strings1[1]) == 0) {
                    result = strings1[0] + result ;
                }
            }
        }
        return result;
    }

    // America
    public static String exerciseSeven(String str) {
        String[] strings = str.split(",");

        String result = "";

        for (int i = 0; i < strings.length; i++) {
            String[] strings1 = strings[i].split("<");
            if (result.equals("")) {
                result = strings1[0] + strings1[1];
            } else {
                if (result.indexOf(strings1[1]) != 0) {
                    result = result + strings1[0];
                } else if (result.indexOf(strings1[1]) == 0) {
                    result = strings1[0] + result ;
                }
            }
        }
        return result;
    }
}