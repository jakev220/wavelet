import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String string = "";

    public String handleRequest(URI url){
        System.out.println("Path: " + url.getPath());
        if (url.getPath().equals("/")){
            return string;
        }

        else if (url.getPath().equals("/add-message")){
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")){
                string += (parameters[1]) + "\n";
                return string;
            }
        }
        return "404 Not Found!";
    }
}

class StringServer {
    public static void main (String[] args) throws IOException {
        if (args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }


}