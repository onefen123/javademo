package com.zsgc.tool;

public class Regex0 {
    //判断ip
    public boolean is_ip(String keywords){
        String regex="([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}";
        return keywords.matches(regex);
    }

    //密码强度(1:弱，2:中，3:强)
    public int check_password(String keywords){
        String ruo="[a-z]*|[A-Z]*|[0-9]*|[^a-zA-Z0-9]*";
        String zhong="([a-z]+|[A-Z]+|[0-9]+|[^a-zA-Z0-9]+)([a-z]+|[A-Z]+|[0-9]+|[^a-zA-Z0-9]+)";
        return keywords.matches(ruo) ? 1 :(keywords.matches(zhong) ? 2 : 3);
    }
    //判断邮箱
    public boolean is_email(String keywords){
        String regex="[a-zA-Z0-9][a-zA-Z0-9_-]{0,20}[a-zA-Z0-9]@[a-zA-Z0-9]{1,9}[-]?[a-zA-Z0-9]{1,9}\\.(cn|xyz|top|hk|cc|biz|wang|vip|(com|net|org|gov|org|edu)(\\.cn)?);" ;
        return keywords.matches(regex);
    }

    //判断身份证（男1,女2,非法0）
    public int is_sfz(String keywords) {
        String regex="[1-8][0-7][0-7][0-9][0-9]{2}(19[0-9][0-9]|20[0-2][0-9])(0[1-9]|1[0-2])(([0-2][0-9])|30|31)([0-9]{3})([0-9xX])";

        int sfz_sum = 0;
        String sfz_arr[]=keywords.split("");
        int factor[] = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String parity[] = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

        if(keywords.matches(regex)){
            for(int i=0;i<17;i++){
                sfz_sum += Integer.parseInt(sfz_arr[i])  * factor[i];
            };
            if(parity[sfz_sum % 11] .equals(sfz_arr[17].toUpperCase())){
                return Integer.parseInt(sfz_arr[16])%2==0 ? 2 : 1 ;
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }

    //是否全部汉字
    public boolean is_hanzi(String keywords){
        String regex="[\u4e00-\u9fa5]{1,}"; //汉字
        return keywords.matches(regex);
    }
    //是否包含有汉字
    public boolean is_hanzi(String keywords,int i){
        String regex=".*[\u4e00-\u9fa5]{1,}.*"; //汉字
        return keywords.matches(regex);
    }

    //判断手机是否手机
    public boolean is_telephone(String keywords){
        String regex="(13|14|15|17|18)[0-9]{9}";
        return keywords.matches(regex);
    }
    //判断url
    public boolean is_url(String keywords){
        String regex="(http[s]?|HTTP[S]?):\\/\\/[a-zA-Z0-9][\\.a-zA-Z0-9-]{3,20}[a-zA-Z0-9]\\/{0,1}.{0,999}";
        return keywords.matches(regex);
    }

    //判断域名(1:1级,2:2级,0:非法域名)
    public int is_domain(String keywords){
        String regex1="[a-z0-9]{1,9}-?[a-z0-9]{1,9}\\.([a-z]{2,5}|(com|net|org|gov|org|edu)(\\.cn)?)";
        String regex2="[a-z0-9]{0,9}\\.([a-z0-9]{1,9})-?([a-z0-9]{1,9})\\.([a-z]{2,5}|(com|net|org|gov|org|edu)(\\.cn)?)";
       if(keywords.matches(regex1)){
           return 1;
       }else if(keywords.matches(regex2)){
           return 2;
       }else {
           return 0;
       }
    }
    //判断日期(2020-12-12)
    public boolean is_date(String keywords){
        String regex="(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
        return keywords.matches(regex);
    }
    //判断日期和时间(2020-12-12 12:12:12)
    public boolean is_date(String keywords,int i){
        String regex="(19[0-9][0-9]|20[0-2][0-9])-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]) (0[0-9]|1[0-2])(:[0-5][0-9]){2}";
        return keywords.matches(regex);
    }

    //判断图片
    public boolean is_photo(String keywords){
        String keywords1=keywords.toLowerCase();
        String regex=".{1,999}\\.(png|gig|jpg|bmp|jpeg)";
        return keywords1.matches(regex);
    }
    //判断账户
    public boolean is_account(String keywords){
        String regex="[a-zA-Z0-9]{1,9}[a-zA-Z0-9-_]{0,1}[a-zA-Z0-9]";
        return keywords.matches(regex);
    }

    //数字或小数
    public boolean is_num(String keywords){
        String regex="[0-9]+(\\.[0-9]+)?";
        return keywords.matches(regex);
    }
}