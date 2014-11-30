
Saki Money - Asynchronous Type-safety Restful Client for Mandrill API
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
- Java Future is blocking operation. You will feel like your code execute concurrently
  for a little while until the Future.get() is reached. Future.get() makes current thread
  waits until the code in another thread in execution context done. 
  This operation will slow down your system because it turns your asynchronous code to 
  be executed serially.     
  This API give you the callback. The current thread will not be blocked when you call 
  Future.get() and your code in callback method is still running concurrently.
- Strong type support. You don't have to worry about type and casting.
- Intuitive and concise API. You will feel natural like sitting beside Saki-Monkey in 
  the jungle when you're coding
- Proxy support  
- Configurable client but doesn't require extra configuration except you don't want 
  the default one.

                       
                      _____ _              _____       _    _ 
                     |_   _( )            / ____|     | |  (_)
                       | | |/ _ __ ___   | (___   __ _| | ___ 
                       | |   | '_ ` _ \   \___ \ / _` | |/ / |
                      _| |_  | | | | | |  ____) | (_| |   <| |
                     |_____| |_| |_| |_| |_____/ \__,_|_|\_\_|
                                                              
    
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
