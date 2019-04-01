# Timeline Project
## Guide for Students
1. Clone project repo
1. Open project in NetBeans
1. In the project folder (Java244), add a new folder named "Timelines"
1. Run the main method in TimelineController.java
1. You may need to run this twice.  the first run on your computer it will not find the timeline file and need to build and save one in the Timelines folder you created in earlier steps.
1. Profit

## Functionality
Currently only supports viewing of a hardcoded timeline, which I put together from  [Wikipedia](https://en.wikipedia.org/wiki/Timeline_of_computing_1990%E2%80%931999).

If you are interested in adding your own events to the timeline, you'll need to look at the code.

    protected void buildDefaultTimeline(){
            Timeline tl = new Timeline("Timeline");

            tl.add(new TimelineItem(LocalDateTime.now()));
            tl.get(0).setTitle("Macintosh IIfx");
            tl.get(0).setDesc("Released");
            tl.get(0).setEventDate(LocalDate.of(1990, 3, 19));

In the method buildDefaultTimeline, you can copy my format for adding events.  It is pretty self explanatory, just know that you will have to increment the get() number for new timeline added. And as an added note, the date format used in this code goes (year, month, day).

You'll need to delete any files that have previously been created by the program for this code to run, so go into the Timlines folder you created and delete any .ser files there. Once that's done you can re run the program and see the events you added in the timeline.
