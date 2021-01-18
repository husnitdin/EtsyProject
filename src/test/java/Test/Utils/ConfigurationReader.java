package Test.Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

    public class ConfigurationReader {

        // #1. we create properties object
        private static Properties properties = new Properties();

        // to make sure this runs before everything else we use static block
        static {
            try {
                // #2. we get the path and pass it into the FileInputStream, to open the file
                FileInputStream file = new FileInputStream("configuration.properties");

                // #3. we load the opened file inti properties object
                properties.load(file);

                // #5. close the file
                file.close();

            } catch (IOException e) {
                System.out.println("Properties file not found");
            }
        }

        // #4. we read from the file
        public static String getProperty( String keyWord ){
            return properties.getProperty( keyWord );
        }

    }

