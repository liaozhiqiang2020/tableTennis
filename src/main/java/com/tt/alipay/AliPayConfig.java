package com.tt.alipay;

public class AliPayConfig {
    public static final String returnUrl="https://www.infhp.cn/mc/alipay/aliPayInquiryReturn";

    public static final String notifyUrl="https://www.infhp.cn/mc/alipay/aliPayInquiryNotify";

    public static final String appId="2018072660765376";
//    public static final String appId="2016100200644505";

    public static final String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArobHtE30OWswMZbh+G+sy3R042jstRYwsFCAtvRZjeIFVSjFSlvW06s+EjmyieBYPI5M/A2hdvpm6QQRhW3UGYbe5FJFtB16v1aRbq1Ca/5AKbLGLcPlQl3GyoIImTGuRo1RJgb7pJS91Rkzw66M8euA7ga/jVyVtgnwpKjdmG/XQBETFJiyhnlO3U9jDmf7NHNV8GLwioL41Ht2wTfHosHoVV7ZPadoLWL+Yxm51rQH1qIjpIF0+1Diw/rEQkE0xI1Ap2nct9Dpaq0qjLyfBmx7bhgTdU8Wsi/CaKmhH0J1DmuHlJLRle9XLv39nlI2ktWgVE6Ggz24N5P1d535UQIDAQAB";
//public static final String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzygImv6GV44VzgWjEB5tE/UGtBQHiP3axf12thQ77UfbBrTjrmpofqPBS+IOumyhcxyrwCm/oBvwgpMS+F7ZjgoDAFl8PhsTCfrEpOr+jf7wJU77/9EgGNUB9akFBRtTlPqa3/rf7cXzZ6XKkwJqYEn4IxAzHyAbVYDP883c+RP7WE+gR6yRKua33Wfu675713GtaFPRag+Vx3tJMRffQ4C7pF3mmWu0okrDIl06uSP4UYUXQIWkG8GQ0y9yHXmvUZwh4z0bzkLvWWvqFkJmQjEoxBR9N41ddJijsLK6QRyQ6lhaBzxWgCyPfKHPom/uobkmdxBAnCgE9BojmKXC5wIDAQAB";

    public static final String privateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbKcTNlEdDKiUFNKm78r4qv/Sbp6U4EOqrEBq0h/HlGen8vRTHBSx+4X/h2I4DuYJQptZRUgxtyCgWiW7/NYMLHlVR7ZwTAuhjQTXS5RFQA42zCnX2+TJDkMf2yz3EYWR8hTQzsEuw6F5errc7Ja3iCUTUU2SlHoLJV4H6f0VDlvnKp+l+uhZDthgA3olFa3cOijYY6UE2RpZXlDnx69nqfaIz+fACgkDQrJ9VlXVB+IKGJ6IfeMeqqzTFng5I3gBIzy6nMNNd5BCOO10VXlF6DFNC9y3gDg2N0FANeZKJXDlRNvtGQh1aJeabceTPEfiYsm4Tc8Yxpfx1rTNEb/vlAgMBAAECggEAJXlNAqmRHHONRViWtcHGk+SQWxd+G7BaPL5C9N7wWPiNPnEcF4T0XiBwFkeK5PNkub3RfQpn3gu9QtQmbpSp9YF58bOFQkIthes16J1SNRTmoBsiqmc88HyDDuO/IzKyZjB1jxZA8ZTtVci0kCBlgnXinbUWVZqs05vC1JDwVYY8jOF10w2NWvFmPskNPpl5vm0qp/40FzdH9eyId4tQXV2IXibIR7JEC/GYUPUKCVmW+xYdyd6hkPpcB3Y1n6MGswm2AwjGIC4zuJY2zxxPR3b947YYZ0WETxfe+5yj8N5jqX5I+G1708aVIJ8Fukf6o8LV68v6LfqyVtTyEd1NgQKBgQDUq3+vXNfZig+LkYJehGoz0vpRJ0wjW++pJZwuWCG5wme+xheH6YM65zY9CS2W6EsL/JKzmDTyKhLGGkNiHaD8wXFj4AjWqCqmwnlj837MhU21dBv75SqfdTbAs/O0jty7/LbknsLzsdlyNkq4YsHDhtXDEOrBYeTyqQjwT6L1fQKBgQC6xtC3DQ/XRlGVjdfMsT1sgoz3K07l/2uT5VyLHUEaIQDFBwhHYublVZtSJePXY6WQmUj3EYMuE6ZCxr+1labh6x7DAKAbnm24nVb6BEHAzZEtpaU8wxb/x8rTB49R423BIgGiOSa4SmL0PwuCtK4Qx6HltfhDVyXDlH9e2/fMiQKBgQCrkyTzTJsT9W9vMViVeozX/KlYmbSyfjSPKTmkphOnczER120aiIkIF4tJmMMAEa6iIAYXAIAOs2TsEDo2ySKdaE9bvV5EF+45FYKr4cF1rUIxV1hQU+WcOguPUl8WV3+75jmDnpY3109P9n833OzoGzsQIfDTTXBRWZBNmGInXQKBgQCXy+NvEeeQ7y55HImJa3bfTI7ihskdteOplFwNF96ELNRiTN/WnLPJKTUNo4uzzuGNTnb1jb8OYJvcY4kFPDYgICWlGEoHiE/mHcHFelYyKx/VeG19n5R+ltLphZheVjcqIsgvHsGwP4yCswZY2R0quASFG8pEeHxRosuNvbp7+QKBgDTsZLe93qVCsqx8aaDL8BnRx/Q4Gk1ugT0VcyeSk2QiQqKsY30gZrEAhbCW53YaX+EnIGgCjo6a0rbPkXBe20OuGSZVOZmuXufAIC0cFGgtdkSdJwdt6QwSkMik9vV7AS06jhQYIfylUid8DNJ+3flqStU+IMuUQFjr7B+5161j";
//    public static final String privateKey="MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDPKAia/oZXjhXOBaMQHm0T9Qa0FAeI/drF/Xa2FDvtR9sGtOOuamh+o8FL4g66bKFzHKvAKb+gG/CCkxL4XtmOCgMAWXw+GxMJ+sSk6v6N/vAlTvv/0SAY1QH1qQUFG1OU+prf+t/txfNnpcqTAmpgSfgjEDMfIBtVgM/zzdz5E/tYT6BHrJEq5rfdZ+7rvnvXca1oU9FqD5XHe0kxF99DgLukXeaZa7SiSsMiXTq5I/hRhRdAhaQbwZDTL3Idea9RnCHjPRvOQu9Za+oWQmZCMSjEFH03jV10mKOwsrpBHJDqWFoHPFaALI98oc+ib+6huSZ3EECcKAT0GiOYpcLnAgMBAAECggEBAJsMf8RilPKbaj6VgYLjAwlY7/eAtlMWjdR67YtCgcgLbCgM5Az7n9KJhnfhbtyhygV6hCKEHOUdhFp28k/rzjG91JlCYPerFAj4JI67RGPLWLrT71F9mOR9KcZRB2zXEywClkDmaQxyiMgfEwwNVslTE+JKkbjOMydADmWQw7+4l92fv2tdK7nq0eYR1bUOK8R1ugR7NL3yioelvz3hQhRalC08IaGv20ssf73kMQEaQnJRuvBowmjF0g5O74z39F783QgCGDPSaKdMRsaFb5olQE35dOLgW6VliwVtHYiuQg02W+Gp9THJSC97Odi5pUaLy6zm8jqiJmXDpy0Mq+ECgYEA8X2UQnldUosdYYyVs7eIdHP0lZ1VxQcet6f1AWptOycmPK9b+uHmujDCntCdjdD+AYqOGc+oTDhA2NyI2Nm4n8hYsyqbY5hnYjYbvHsP3OGivkdWyjjipre59g7Zpr7MEoKcxFDnAdwZHq8o5NOqEuAPHHIOAQ7NAbKF7LPr0VUCgYEA25paWeLJH1CyFR2tSEHSnS3/PZu+eaT5jKzaL5/rIGryjXIirkpvg0oZNqgcvtpvzdY0BjfqwHKVmbwRbm2SKqjM4PL2mXigLZSZ8UK0Kg94YROJ5DKEDz31qQt/68s8FXcdt10pxM7WaQ3Ag6kdlsgmp/ZXHOk1A2xyeWZts0sCgYEAtI0mlxi0XG2kdvWsS6TyAddcS6xJnzj2j2uk8/0FVA+uN/sIMyhI4HZqXGEvGwPhlXdpTQUEGJCKc1lXe4I01kntf29gpHMjALvhuubrckLE8azWx/UGCI4fHEf4FQJcA47h9KlkPfC4W0estIFIjDo3MhZYQBQ31IgMN3BB5M0CgYEAuxtNhi57jIn14ZXykZE7wR5yzexII18UHO8dy9wmuu1Eko2/zN6xGpzk1LPyIg79mdS7aNz10FkQ6/bYp00GcAB45+U7hVHIsG1fqLdbyEZ8G8JJB7ye1lnFWO3qZV45aFSgZh4ju4M8HjBQah2Kj3EjtpJmcMSmna8l7hf+ufcCgYEAixMwMPesyz2UzTljk0OEIKOZsJf5yk9jY2qVSXJ27JaJqbLIQLQAHEmBXt/HwUlFgbxXrSNJpUUWM5v7ZsIuF2QAAcqeJk6VZh30wdYTkmtUnzMREhzP0vMCFYcpSXFpQezfcT/CEsWoExV07//RDLDR7As5ebwlAbIeu82zWVA=";

    public static final String apiUrl="https://openapi.alipay.com/gateway.do";
//    public static final String apiUrl="https://openapi.alipaydev.com/gateway.do";

    public static final String charset = "UTF-8";

    public static final String signType="RSA2";

    public static final  String alipayurl = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm";
}
