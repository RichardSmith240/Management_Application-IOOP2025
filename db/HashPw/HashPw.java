import org.mindrot.jbcrypt.BCrypt;
public class HashPw {
  public static void main(String[] args) {
    String pw = args.length > 0 ? args[0] : "demo123!";
    String hash = BCrypt.hashpw(pw, BCrypt.gensalt(12));
    System.out.println(hash);
  }
}