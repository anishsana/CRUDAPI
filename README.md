*NOTE - This API is no longer hosted. The code provided in this repository can be repurposed and hosted.*

# CRUDAPI
A simple CRUD API for books.

# USAGE

## Add Books
Required parameters -
* `isbn` - ISBN (International Standard Book Number) of the book
* `title` - Title of the book
* `author` - Book's author

`curl -i -X POST -H "Content-Type:application/json" -d "{  \"isbn\" : \"978-0156027328\",  \"title\" : \"Life of Pi\", \"author\" : \"Yann Martel\" }" http://crudapi.us-east-1.elasticbeanstalk.com/books`

## Get Books
### By ISBN
Retrieves a book by its ISBN. Since ISBNs are unique, a single book is returned. Required parameter - `isbn`

`curl http://crudapi.us-east-1.elasticbeanstalk.com/books/search/findBookByIsbn?isbn=978-0156027328`

### By Title
Retrives books by the provided title. All books matching the title will be returned. Required parameter - `title`

`curl http://crudapi.us-east-1.elasticbeanstalk.com/books/search/findBooksByTitle?title=Life%20of%20Pi`

### By Author
Retrives all books written by the author. Required parameter - `author`

`curl http://crudapi.us-east-1.elasticbeanstalk.com/books/search/findBooksByAuthor?author=Yann%20Martel`

## Find Top 10 Words
Retrieves the top 10 words used in all book titles.

`curl http://crudapi.us-east-1.elasticbeanstalk.com/top10words`
