package constants;

public class Constant {

    public static String baseUrl = System.getProperty("baseUrl");
    public static String userInsertionURL = "/calculator/insert";
    static String currentDirectory = System.getProperty("user.dir");
    public static String fileToLoadPath = currentDirectory + "/src/main/resources/dataUpload.csv";
    public static String testFileData = currentDirectory + "/src/main/resources/testData.csv";
    public static String rakeDBUrl = "/calculator/rakeDatabase";
    public static String insertDBURL = "/calculator/insertRandomToDatabaseForNoReason?count=";
    public static String dbDetailURL = "/calculator/taxRelief";
    public static String insertMultipleDataURL = "/calculator/insertMultiple";
    public static String insertFileDataURL = "/calculator/uploadLargeFileForInsertionToDatabase";
}
