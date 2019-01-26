package chap2;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    /**
     * 不是用库函数的解法
     * 1. 统计空格数目
     * 2. 增长原字符串的长度
     * 3. 使用两个指针，一个指向原来字符串末尾，一个指向新字符串末尾。
     *      从后往前扫描字符串，并左移指针
     */
    public String replaceSpace(StringBuffer str){
        if(str == null)
            return null;
        // 1. 统计空格数目
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ')
                spaceNum++;
        }

        int oldPoint = str.length() - 1;    // 标记原指针的末尾位置
        // 2. 增长原字符串的长度
        str.setLength(str.length() + spaceNum * 2);
        int newPoint = str.length() - 1;    // 标记新指针的末尾位置
        // 3. 扫描
        while(oldPoint >= 0 && newPoint > oldPoint){
            if(str.charAt(oldPoint) == ' '){
                str.setCharAt(newPoint--, '0');
                str.setCharAt(newPoint--, '2');
                str.setCharAt(newPoint--, '%');
            }else{
                str.setCharAt(newPoint--, str.charAt(oldPoint));
            }
            oldPoint--;
        }

        return str.toString();
    }

    /**
     * 遍历每一个字符，如果是空格就是用java库函数repalce替换
     * @param str 原字符串
     * @return 替换空格后的字符串
     */
    public String replaceSpace2(StringBuffer str){
        if (str == null)
            return null;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                str.replace(i, i+1, "%20");
        }

        return str.toString();
    }

    /**
     * 使用replaceAll来替换
     */
    public String replaceSpace3(StringBuffer str){
        return str.toString().replaceAll("\\s", "%20");
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace3(new StringBuffer("we are happy")));
    }
}
