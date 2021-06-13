## Assessment Task
This task ticks all the features listed below
### MainScreen (also Landing Fragment)
- Display a list of Westwing campaigns retrieved from the following API endpoint:https://static.westwing.de/cms/test/campaigns.json
- Display each item’s image in 4:3 aspect ratio and display the campaign name on topof it (making sure it’s readable)
- Separate the items visually by 8dp of white space
- When the user taps an item, opens the corresponding detail screen 
- Do not display campaigns with empty name or description
- (Optional) Displays 1 item per row in portrait mode, 2 items per row in landscape
### Detail screen:
- Display the campaign image in full screen
- Display the title and description over the image
- Display a “Call Now” button
- On tapping “Call Now, request permission & call the Westwing customer support
- The user is be able to return to the list after the call
- (Optional) Swiping left or right opens the previous/next campaign in the list
- (Optional) Allows transition from the main screen to the detail screen by zooming the image
### Optional:
- Displays an error screen when there is a networking problem.
- The error message say: "There was an error. Please check your internet
connection and try again."
- Below the error message, shows a button saying "Retry".
- When the user taps Retry, the app should try to reload the data and display the screen with the rendered 
  list of campaigns. If the loading fails again, it should display the error page again.
  
  
### Demo
![Demo 1](https://media.giphy.com/media/D9bG04mMUJcVvihZJN/giphy.gif)
![Demo 2](https://media.giphy.com/media/uJ1kQXFMNnKFMMrKMy/giphy.gif)

