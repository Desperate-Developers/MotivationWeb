# MotivationWeb
A web service that provides motivational quotes. Developers can incorporate the service into their applications to provide users with an inspirational message when the application launches or at any time suitable.

The endpoints to obtain:
* a random quote: http://softwarepulse.org:8085/motivate/me/quote
* all the quotes from the database: http://softwarepulse.org:8085/motivate/me/quotes/all
* a list of names of all the authors of the quotes: http://softwarepulse.org:8085/motivate/me/quote/author/list
* a random quote from a specific author: http://softwarepulse.org:8085/motivate/me/quote/author?author=specifiy_name_of_author
* all the quotes by a particular author: http://softwarepulse.org:8085/motivate/me/quote/author/all?author=specifiy_name_of_author
* a list of all the categories: http://softwarepulse.org:8085/motivate/me/quote/category/list
* a random quote under a certain category: http://softwarepulse.org:8085/motivate/me/quote/category?category=name_of_category
* all the quotes under a category: http://softwarepulse.org:8085/motivate/me/quote/category/all?category=name_of_category
* a quote by its id: http://softwarepulse.org:8085/motivate/me/quote/id?id=id_value
