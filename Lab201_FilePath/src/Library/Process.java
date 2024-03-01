package Library;

public class Process {
    public String normalizeName(String name)
    {
        name = name.trim().toLowerCase().replaceAll("\\s+"," ");
        char c = Character.toUpperCase(name.charAt(0));
        name = c + name.substring(1);
        StringBuilder sb = new StringBuilder();
        char[] hehe = name.toCharArray();
        for(int i = 0; i < hehe.length; i++)
        {
            if(hehe[i] == ' ')
                hehe[i+1] = Character.toUpperCase(hehe[i+1]);
            sb.append(hehe[i]);
        }
        return sb.toString();
    }

    public String[] splitName(String name)
    {
        return name.split(" ");
    }

    public String middleName(String[] name)
    {
        StringBuilder middleName = new StringBuilder();
//        for(int i = 1; i < name.length - 1; i++)
        for(String word : name)
        {
            middleName.append(word).append(" ");
        }
        return middleName.toString().trim();
    }
}
