package NumSequence;

public class L_1108_DefangingAnIPAddress {

    /*
        Given a valid (IPv4) IP address, return a defanged version of that IP address.

        A defanged IP address replaces every period "." with "[.]".

        Example 1:
            Input: address = "1.1.1.1"
            Output: "1[.]1[.]1[.]1"
        Example 2:
            Input: address = "255.100.50.0"
            Output: "255[.]100[.]50[.]0"

        Constraints:
            The given address is a valid IPv4 address.

     */

    public static void main(String[] args) {
        L_1108_DefangingAnIPAddress l = new L_1108_DefangingAnIPAddress();
        String ip = "1.1.1.1";
        System.out.println(l.defangIPaddr(ip));
        ip = "255.100.50.0";
        System.out.println(l.defangIPaddr(ip));
    }

    public String defangIPaddr(String address) {
        return defangIPaddr1(address);
    }

    public String defangIPaddr1(String address) {
        byte[] b = new byte[address.length() + 6];
        byte index = 0;
        for (int i = 0; i < address.length(); i++) {
            if ('.' == address.charAt(i)) {
                b[index++] = '[';
                b[index++] = '.';
                b[index++] = ']';
            } else {
                b[index++] = (byte) address.charAt(i);
            }
        }
        return new String(b, 0, b.length);
    }

}
