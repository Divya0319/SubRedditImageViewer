# SubRedditImageViewer
 An app to view and cache images from subreddit

* It contains two modules, "app" and "imageloader", among which, "imageloader" contains the code to download image from the url given to it by "app".

* For caching the bitmaps, it uses LruCache provided by the Android Framework.

* The motive was to use DiskLruCache, but the code samples available on the web were unclear, and by not following any kind of caching libraries, the plain code had too much dependencies of other classes, which could not be completed in this less time.

* It is assumed, that cache gets cleared on every relaunch of the app, and so on every new app start, the cache is cleared and re-initialized.

* The app follows MVVM design pattern, and for dependency injection, Dagger framwork is used.

* The network calls are made by utilising Retrofit2 and RxJava2 features in synergy.

* The JSON parsing is done by using Google's GSON library.

* The JSON response contained url field inside a container object named "data" which was contained inside another container jsonarray "children".
 But, the only data required was url field, and it contained some urls of images which were either gifs, or some formats other than .jpg or .png. So only .jpg or .png     urls were passed to the image loading library, due to limitations of Android framework, and making the process of image loading as simple as possible.

* While developing the project, some circular dependencies popped up between app and imageloader module due to restrictions present in the usecase of the task.
So, to resolve those dependencies, it is assumed the only app module will depend on the classes of imageloader module, and not vice versa.Hence, some of the classes from app module needed to be moved inside the imageloader module to resolve the circular dependency issue.

* The app is not implementing using databinding as of now, but can be done in future.
