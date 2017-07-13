/**
 * Created by Ny Derry on 7/12/2017.
 */
public class Library {


        String library_address;
        static String library_hours = "Libraries are open daily from 9AM to 5PM";
        Book[] catalog = new Book[0];
        int numberofBooks = 0;

        //List of Methods for Libraries
        public Library(String address) {
            library_address = address;
        }

        public static void printOpeningHours() {
            System.out.println(library_hours);
        }

        public void printAddress() {
            System.out.println(library_address);
        }

        //Add books to library catalog
        public void addBook(Book newbook) {
            if (numberofBooks >= 0) {
                Book[] newarray = new Book[(numberofBooks + 1)];
                System.arraycopy(catalog, 0, newarray, 0, numberofBooks);
                catalog = newarray;
            }
            catalog[numberofBooks] = newbook;
            numberofBooks++;
        }

        //Check out book from catalog
        public void borrowBook(String title) {
            String string1 = title;
            if (catalog.length == 0) {
                System.out.println("Sorry, this book is not in our catalog");
            }
            for (int i = 0; i < catalog.length; i++) {
                if (string1.equals(catalog[i].book_title) && catalog[i].isBorrowed() == false) {
                    catalog[i].Borrow();
                    System.out.println("You successfully borrowed " + catalog[i].getTitle());
                    break;
                } else if (string1.equals(catalog[i].book_title) && catalog[i].isBorrowed() == true) {
                    System.out.println("Sorry, this book is already borrowed.");
                    break;
                } else if (string1.equals(catalog[i].book_title) == false) {
                    System.out.println("Sorry, this book is not in our catalog");
                    break;
                }
            }
        }

        //Return book to library
        public void returnBook(String title) {
            String string1 = title;
            for (int i = 0; i < catalog.length; i++) {
                if (string1.equals(catalog[i].book_title) && catalog[i].isBorrowed() == true) {
                    catalog[i].Return();
                    System.out.println("You successfully returned " + catalog[i].getTitle());
                    break;
                }
            }
        }

        public void printAvailableBooks() {
            if (catalog.length > 0) {
                for (int i=0; i<numberofBooks; i++) {
                    System.out.println(catalog[i].book_title);
                }
            } else {
                System.out.println("No books in catalog currently.");
            }
        }

        public static void main(String[] args) {

            System.out.println("Library Hours:");

            //Create two libraries
            Library firstLibrary = new Library("10 Main St.");
            Library secondLibrary = new Library("228 Liberty St.");

            //Add four books
            firstLibrary.addBook(new Book("A Game of Thrones"));
            firstLibrary.addBook(new Book("Rama"));
            firstLibrary.addBook(new Book("Understanding Space"));
            firstLibrary.addBook(new Book("Way of the Clans"));
            secondLibrary.addBook(new Book("Mechanics of Propulsion"));
            firstLibrary.addBook(new Book("A Feast for Crows"));
            firstLibrary.addBook(new Book("A Dance of Dragons"));

            //Print opening hours and address
            System.out.println("Library Hours:");
            printOpeningHours();
            System.out.println();

            System.out.println("Library addresses:");
            firstLibrary.printAddress();
            secondLibrary.printAddress();
            System.out.println();

            //Try to borrow A Game of Thrones from both libraries
            System.out.println("Borrowing A Game of Thrones:");
            firstLibrary.borrowBook("A Game of Thrones");
            firstLibrary.borrowBook("A Game of Thrones");
            secondLibrary.borrowBook("A Game of Thrones");
            System.out.println();

            //Print the titles of all available books from both libraries
            System.out.println("Books available in the first library");
            firstLibrary.printAvailableBooks();
            System.out.println();
            System.out.println("Books available in the second library");
            secondLibrary.printAvailableBooks();
            System.out.println();

            //Return A Game of Thrones to the first library
            System.out.println("Returning A Game of Thrones");
            firstLibrary.returnBook("A Game of Thrones");
            System.out.println();

            //Print the titles of available books from the first library
            System.out.println("Book available in the first library");
            firstLibrary.printAvailableBooks();
        }
    }

