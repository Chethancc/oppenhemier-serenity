package fixtures;

import constants.ContextKey;
import fileReaders.CsvReader;
import model.request.UserRequest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserInsertionData
{
  String currentDirectory = System.getProperty("user.dir");;
  public static String filePath = "";

   public static UserRequest getDefaultData(){
       UserRequest userRequest = new UserRequest();
       userRequest.setBirthday("10102000");
       userRequest.setGender("M");
       userRequest.setName("SomeName");
       userRequest.setNatid("SG");
       userRequest.setSalary("20000");
       userRequest.setTax("200");
       return userRequest;
   }

   public static UserRequest createUserData(String profile){
       Map<String,String> userProfile =  new HashMap<>();
       UserRequest userRequest = new UserRequest();
       userProfile = CsvReader.getData(filePath,profile);
       userRequest.setBirthday(userProfile.get(ContextKey.birthday.toString()));
       userRequest.setGender(userProfile.get(ContextKey.gender.toString()));
       userRequest.setNatid(userProfile.get(ContextKey.natid.toString()));
       userRequest.setTax(userProfile.get(ContextKey.tax.toString()));
       userRequest.setName(userProfile.get(ContextKey.name.toString()));
       userRequest.setSalary(userProfile.get(ContextKey.salary.toString()));
       return userRequest;

   }
}
