
Saki Monkey - Asynchronous Type-safety Restful Client for Mandrill API
======
Mandrill API [Document Page](https://mandrillapp.com/api/docs/)

Why we have to develop another client?    
Because we want to move fast, some features don't exist in existing [API clients](http://help.mandrill.com/entries/21738166-API-Wrappers). We can control more with
our own project. Making other clients to support asynchronous operation would not
be a good idea when they are not designed for that purpose in the first place.

##Feature
- All public APIs in Mandrill are implemented.
- All APIs can be accessed in asynchronous fashion.
  Don't worry. You still have synchronous APIs as an alternative choice. 
- Java Future is blocking operation. You will feel like your code being executed concurrently
  for a little while until Future.get() is reached. Future.get() makes current thread
  wait until the code in another thread has finished. 
  This operation will slow down your system because your code will be executed serially
  instead of asynchronously.
  This API gives you the callback. The current thread will not be blocked when you call 
  Future.get() and your code in callback method is still running concurrently.
- Strong type support. You don't have to worry about type and casting.
- Intuitive and concise API. You will feel natural like sitting beside Saki-Monkey in 
  the jungle when you're coding
- Proxy support
- The only configuration that you need to make it run is apiKey. You can either put it 
  in the configuration file or pass it as an argument. Saki is customizable and it ships
  with default configurations that work most of the cases.

##Set up your project dependencies
Saki-Monkey is available on Maven Central

###SNAPSHOT for Maven 

```Xml
<repositories>
  <repository>
    <id>sonatype-nexus-snapshots</id>
    <name>Sonatype Nexus Snapshots</name>
    <url>
      https://oss.sonatype.org/content/repositories/snapshots
    </url>
    <releases>
      <enabled>false</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.jobhive.saki-monkey</groupId>
    <artifactId>saki-monkey</artifactId>
    <version>1.0.0-SNAPSHOT</version>
  </dependency>
</dependencies>
```

###SNAPSHOT for sbt 

```Scala
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "com.jobhive.saki-monkey" % "saki-monkey" % "1.0.0-SNAPSHOT"
```

##Examples
###Ask Mandrill who you are.

Client takes 2 arguments. The first one is apiKey and the second one is     
configuration file. You can pass configuration file path if you want to     
override default configuration. The path can be either file path such     
as "/home/saki/myconfig.conf" or classpath such as "classpath:myconfig.conf"     
Example configuration is in src/main/resource/reference.conf    
Define the same name to override the default one.    

**Example.**    

```Java
    new MandrillAsyncClient("${apiKey}", null).api()
      .users().info(new ObjectResponseCallback<UserInfo>() {
      @Override
      public void onSuccess(Result<UserInfo> result) {
        System.out.println(result.getObject().getUsername());
      }
    });
```

###Send advanced message in a simple way
This is a bit more complicated example. This example show you how    
to send an email with template containing variables and embedded image.    
You can choose to send it in either synchronous or asynchronous fashion.

```Java
    Recipient rcp = new Recipient("somebody@domain", "Somebody");
    rcp.addVar("title", "Saki-Monkey kisses Mandrill")
    .addVar("postedDate", new Date()).addVar("website", "http://www.jobhive.com")
    .addVar("header1", "Feeling productive even I sleep all day long.")
    .addVar("header2", "New banana flavor discovered by Saki-Monkey")
    /* add custom object. With handlebars template, you can pass variable as an object, 
     * a nested object, a map or a list to the template. 
     * Please take a look in test case for more detail.
     */
    .addVar("topics", new Topic[]{
      new Topic("Primate of the Old World"),
      new Topic("Who took my banana?"),
      new Topic("White face cosmatic.")});
    Message message = new Message().setSubject("Message API Test")
      .setFromEmail("youremail@domain").setFromName("yourname")
      /* assume that you want to load message template from file */
      .setHtml(new File("templates/minimalist/template.html"))
      .addRecipient(rcp)
      .addImage(new EmbeddedImage("envelope", "templates/minimalist/images/envelope.gif"));
    /*Send it with synchronous API*/
    MandrillClient client = new MandrillClient("${apiKey}", null);
    Result<MessageStatus[]> result = client.api().messages().send(message);
    /* Do something useful with result */
    System.out.println(Arrays.toString(result.getObject()));
    /* Or error */
    System.out.println(result.getErrorInfo());
    
    /*Send it with asynchronous API */
    MandrillAsyncClient asyncClient = new MandrillAsyncClient("${apiKey}", null);
    asyncClient.api().messages().send(message, new ObjectResponseCallback<MessageStatus[]>() { 
      @Override
      public void onSuccess(Result<MessageStatus[]> result) {
        /* Do something with result */
      }
    });
```
You can use variables in your template because Mandrill supports handlebars     
and mailchimp's merged variable. You can embedded image to the template.   
Just make sure that you put matching name in image tag as well.    
After adding image to the message like the following    
.addImage(new EmbeddedImage("banana", "/home/myhome/banana.gif"));    
You have to provide the matching name to src of img in template    
<img src="cid:banana"></img>     


                      ================================================
                 _____       _    _        __  __             _              
                / ____|     | |  (_)      |  \/  |           | |             
               | (___   __ _| | ___ ______| \  / | ___  _ __ | | _____ _   _ 
                \___ \ / _` | |/ / |______| |\/| |/ _ \| '_ \| |/ / _ \ | | |
                ____) | (_| |   <| |      | |  | | (_) | | | |   <  __/ |_| |
               |_____/ \__,_|_|\_\_|      |_|  |_|\___/|_| |_|_|\_\___|\__, |
                                                                        __/ |
                                                                       |___/ 
    
      ...........'',,,;;;;;,'',,,,'.........     .  . ..'. .','',;;::;;:::;;:::;;,....
      .........'',,,,;;,,''.','',''.. ...... .   .. . ..... .','.',;;::::;:::::;;;,...
      .......''',,,''''',;:loooool;........          ...;llllll:,'',;;,;:;;;;;;;::;,..
      ........',''.',lxOKXXNNNNNNNNKOkoc;..       .'cdOKXXXNNNXXKOdl:;,',;;;;,;;;:;;;,
      ...........';okKNWWWWWWWNNNNNNXXNNX0x:.  .,lkKXXXXXXXXXXNNNNNNKOd:'',,;,',;;;::;
      ..........'ckKNNWWWWWWWWWNNNNNNNNXXXX0l',dKKKKKKXXXNNNNNNNNWWWWNXOo;,'','.,,';;;
      .........'oOXNNWWWWWWWWWWWWWNNNNNNNXXKkod0XXXXXXXXXXXNNNNNNNWNNNWNKkl;,,'..''.,,
      ........'d0XNNNWWWWWWWWWNNNNNNNNNNNNKK0OOKXXXXXXXXNNNNNNNNNNNNNNNWNX0dc''......'
      .....  .d0NNWNNNWWWWNNNNNNWNNNNNNNNXXK0kOKKXXXXXXXXXXXXXNNNNNNNNNNNNNXkc'.......
      ....  .c0NNNNNNNNNNNNNNNNNNNXXXXXNXXXKOdk0KXXXXXXXXXXXXXXXXXNNNNNNNNNNXO:.......
      ...   'kKXNNNNNNNNNNNNXXXXXXKKKKKKKKKOdld000KK0000KKXXXXXKKKXXNNNNNNXXXKx' .....
           .o0KXXXXNXNNNXXXXXXXK000OOOOOOOko:;;ldxkO0000000KKKXXXKKXXXXXXXXXXKO:  ....
           'x0XXXXXXXXXXXXKKKK000000K0000kd:;;;,:lxO00000KK0000KXXXKKXXXXXXXXK0d. .   
           ,xKXXXXXXXXXXKK0K0OOO0000OOkxdl:;;;::;:oxOO0000K000000KKKKKKKXXXXXK0x,.    
           ,OKXXXXXXXXKK000OkkkOOkkkxdolc;,,,'',,;:loxkkkOOOO000OO0KKKKKXKXXXKKO:.    
           ;OKXXXXXXXKK0OOkxdxddlccc:;,...........'',;cloodxxxkkOOOO0KKKXXKKKK0Oc.    
          .:k0KKXXXXK00Okxl::;,'....   .............. ..'..,;:cloxkkOO0KKXKKK0Okl.    
          'oO0KXXXXKK0Okd:,'......     ...............  ........,:lxk000KKXKKK0kc.    
         .lOKXXXXXXK00Okolcc;,,,'...........,,,,,'..'......',,;:cclxkO0KKKKKKKK0x;.   
        .:kKXXKXXXXKK0Okxxxxoc;;,,'.......',;:;;;'..''''',,;;lodddxkOO0KKKKKKKKK0x;.  
        ,dKXXKXXXXXXK000OOOkxxdolllcc:,'.';:cccc:;,';cccllllodxxkkOkO00KKKXKKKKKK0o.  
       .o0XXKKKXXXXKKKK00OOOOkOkkkkdc,..',,;cccc:;,'';lxkxxxxkkkkkkOOO00KKKKKKKKKKk'  
       .xKXKXKKXKKKKKXXKK0000OOOkxl,...',;;;:::::;,'...;oxkkkkkkxxxkkOO0000KK0KKKKk:  
       ,xKKKXKKKKKKKKKKK0OOOkxxdo:'....':ccc:;::cc:,....'cdxxxxxdddddxOOOO00K00K00Oc. 
      .cOKKXKKKKKKKKK00Okkkxdol:;'.....;ll:;,,,:cllc;;,..,clloooolododkkkOOO000000Oc. 
      .lOKKKKK0K0K000OOkxdoll:;,'..''';cc;,''..',;cll::;..,;;:::ccllodxxkkOkOOOOOOk:. 
      .,x0K00000000OOkxool:;,,''.....''...... ......';;,...',,,,;;:cllddxkxkkkkkOOx;  
      ..oO000OO00OOkxdocc;,''.....                  ........''''',,::cooxxxkxxkxkko'  
       .:dkOOOOOOOkxdoc:;'...............''''.''',''''.''....'''.',;::lodddxxxxxxd:.  
        'lxOOOOOOkkdoc:;,'''........',;::c::;,:;clccc:;,'.....''..,;::llodddxkxkxl'   
        .cdkO0OOOkxdl:;,,'''.. ......';;;,;;,',,:c:::;,'......'''.,;;:cloddxxxxxdc'.  
        .:okOOOOOkxol:;,,''.....................,''''''.......'''.,:;:clooddxxxdo:..  
         'cdkkkkkkxolc:;,,'... ......            .............''.',;;::llooddddoc,.   
         .,lodxxkkxolc:;;,''.....              ...       ....'''',;;;:clooooooll;.    
          .,clddxxxdlc::;;,''.....             ..        ...'',,;;;;:cllooooolc;.     
           .';lodddooc:::;;,'''....                     ...'',,;;;;cclooddoolc,..     
            .';:lloollc:::;;;,,''.'...                ......',;;::clloodoool:,..      
             ..,,:cllllc:::::;;;,,,,,'..            .....''',;;:cllooooollc;'.        
               ..,;:ccccc::c::;;;;;,,,'....      ...'''''',,,;:ccclllllcc;'.          
                 ..,;:;;;;;;;,;,,,','''......  .....'''''',,;;;::::;;,,'..            
                   ..'''''..''''''........      .........''''''''.......              
                       ..............                  ........                       
