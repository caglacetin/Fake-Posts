Since there is no so many action in a screen like like-unlike post, 
I have preferred to use MVVM architecture instead of MVI to build this application.

According to MVVM, model classes are important to update ui.

I also tried to apply separation of concern by creating data, domain and ui packages. 

Repository - To fetch necessary data from service.
UseCase and Mapper - To handle api calls and response mapping.
ViewModel - To provide required data for activity
State - Represents states of the view.

I have used Dagger2 for dependency injection
and used Rxjava3 for the async threads and data transformations. 

I wrote unit test for viewModel and viewStates.
