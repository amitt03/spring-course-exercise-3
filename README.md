
Exercise 3
==========

Have a look at the project, it has been restructed a bit<br/>
- **dao** package<br>
  Contains book and member dao for performing data-store operations **(DO NOT EDIT PACKAGE CONTENT)**
- **model** package<br/>
  Contains the data structures that are used to model our library **(DO NOT EDIT PACKAGE CONTENT)**
- **BookAnalyzer** class<br/>
  Utility for analyzing books in order to discover their Genre
- **AppConfig** class, as usual, for your configuration
- **Main** class, as usual, for running your code (preloaded with some simple logic)
- **Library** class is the main service with library like operations
<br/>

1. Create a spring project that contains the necessary beans (start by looking at the Library and what it needs)<br/>
   This time annotate the beans themselves using the appropriate bean stereotype.<br/>
   *Remember, there is NO need to touch the dao and model directories*
<br/>

2. Set the **Library** class **open** method to be automatically executed when the library is created
<br/>

3. In the **Library** class implement the following methods (See TODOs in the code):
    - "createMembership" method
    - "addNewBook" method<br/>
    New books MUST be analyzed in order to define their real Genre<br/>
    (Do not worry if the book analyzer returns an NA genre)
    - "searchBooksByAuthor" method
<br/>

4. Execute the project
   - Run **main** method and make sure it runs successfully (you do not have to add any code at all)

###N O T I C E
- [ ] **DO NOT** edit anything from the dao and model folders
- [ ] **DO NOT USE** @Bean
- [ ] **DO NOT USE** @Import
- [ ] **Use** @ComponentScan
- [ ] Check the log


