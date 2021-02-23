# CRUDApplication
*SpringBoot Application which shows basic CRUD database operations using REST API.*

JPAImpl: 
* This application uses embedded in-memory H2 database.
* On StartUp of application data is inserted into POST entity table from data.sql present in resources.

**REST Endpoints for opereations:**
1. View all posts : [GET] ->  `localhost:8080/posts`
2. View a specific post :  [GET] -> `localhost:8080/post/view/1`
3. Create a Post : [POST] -> `localhost:8080/posts/create`
- Request Body:
{
	"id" : 2,
	"title" : "my paytm",
	"body"  : "after ticket purchase",
	"balance" : 90
}
4. Update a Post  by Id : [PUT]  -> `localhost:8080posts/edit/1`
- Request Body:
{
	"id"  : "2",
	"title" : "my paytm",
	"body"  : "ticket cancelled",
	"balance": 200
}
5. Delete a Post by Id : [DELETE] -> `localhost:8080/posts/delete/{id}`
6. Debit Amount from a Post by Id : [GET] -> `localhost:8080/posts/debit/{id}/{amount} `

* A ConcurrentClient class has been put in CLient package to perform Step 6 where concurrent requests were made by 2 threads accessing same resource.
* This Client is created using apache httpcomponents.
