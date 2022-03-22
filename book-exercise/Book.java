/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 // * @author (Doreen Oduro)
 * @ID (10916516)
 * @version (17th March 2022.)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private boolean onLoan;
    private int loanCount;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
        onLoan = false;
        loanCount = 0;
    }

    // Add the methods here ...
    public String getAuthor()
    {
        return author;
    }
    public String getTitle()
    {
        return title;
    }
    public int getPages()
    {
        return pages;
    }
    public void printDetails()
    {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
        if(refNumber.length() == 0) {
            System.out.println("RefNumber: " + refNumber);
        } else {
            System.out.println("zzz");
        }
        System.out.println("Loan Status: " + onLoan);
        System.out.println("Number of counts: " + loanCount);
    }
    public void setRefNumber(String ref)
    {
        if(refNumber.length() < 3){
            ref = refNumber;
        } else {
            System.out.println("Error: ");
        }
    }
    public String getRefNumber()
    {
        return refNumber;
    }
    public boolean getLoan()
    {
        return onLoan;
    }
    public int getLoanCount()
    {
        return loanCount;
    }
    public void borrow()
    {
        if(onLoan == false){
            onLoan = true;
            loanCount++;
        } else {
            System.out.println("The book is on loan");
        }
    }
    public void returnBook()
    {
        if(onLoan == true) {
            System.out.println("The book you are trying to return is not on loan.");
        } else {
            onLoan = false;
        }
    }
}
