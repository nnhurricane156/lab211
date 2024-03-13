package Model;

public class Properties {
    private String account;
    private String accountError;
    private String password;
    private String passwordError;

    private String captcha;
    private String captchaError;

    public Properties(String account, String accountError, String password, String passwordError, String captcha, String captchaError) {
        this.account = account;
        this.accountError = accountError;
        this.password = password;
        this.passwordError = passwordError;
        this.captcha = captcha;
        this.captchaError = captchaError;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountError() {
        return accountError;
    }

    public void setAccountError(String accountError) {
        this.accountError = accountError;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptchaError() {
        return captchaError;
    }

    public void setCaptchaError(String captchaError) {
        this.captchaError = captchaError;
    }
}
