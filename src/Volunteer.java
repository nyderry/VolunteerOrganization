/**
 * Created by Ny Derry on 7/12/2017.
 */
public class Book {


        Boolean isCheckedOut = false;
        String book_title;

        public Book(String title) {
            book_title = title;
        }

        public void Borrow() {
            isCheckedOut = true;
        }

        public void Return() {
            isCheckedOut = false;
        }

        public boolean isBorrowed() {
            if (isCheckedOut == true) {
                return true;
            } else {
                return false;
            }
        }

        public String getTitle() {
            return book_title;
        }

/*public static void main(String[] args) {
    Book example = new Book("A Game of Thrones");
    System.out.println("Title: " + example.getTitle());
    System.out.println("Borrowed?: " + example.isBorrowed());
    example.Borrow();
    System.out.println("Borrowed?: " + example.isBorrowed());
    example.Return();
    System.out.println("Borrowed?: " + example.isBorrowed());

}*/

    }

