<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<div class="container" ng-hide="rememberPassStatus">
    <div class="bs-calltoaction bs-calltoaction-primary">
        <div class="row">
            <form class="form-signin" ng-submit="login(user)">
                <p class="field">
                    <input type="text" class="form-control" ng-model="user.login" name="username" id="username"
                           placeholder="Логин"/>
                </p>
                <p class="field">
                    <input type="password" class="form-control" ng-model="user.password" name="password" id="password"
                           placeholder="Пароль">
                </p>
                <p class="submit cta-button">
                    <button class="btn btn-lg btn-block btn-primary" type="submit" name="submit">Войти</button>
                </p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

        </div>
    </div>
    <div class="row">
        <div align="right">
            <div class="btn-group cta-button">
                <button ng-click="rememberPass()"
                        class="btn btn-primary btn-xs">Востановить пароль
                </button>
                <button ng-click="rememberPass()"
                        class="btn btn-primary btn-xs">Зарегистрироваться
                </button>
            </div>
        </div>
    </div>
</div>
<div class="container" ng-show="rememberPassStatus">
    <div class="bs-calltoaction bs-calltoaction-primary">
        <div class="row">
            <div id="progressbar" ng-show="progressbar" class="progress-bar  progress-bar-striped active"
                 style="width: 100%">{{resultSend}}
            </div>
            <span class="alert">{{rememberPassResult}}</span> <br/>
            <form name="forgetPass" ng-submit="sendRequestRememberPass(email)">
                <p class="field">
                    <input type="email" class="form-control" name="email" required ng-model="email.email"
                           placeholder="Email"/>
                </p>
                <div ng-show="forgetPass.email.$invalid && forgetPass.email.$dirty" class="error">
                    <p class="label label-danger">
                        <span ng-show="forgetPass.email.$error.required">поле не должно быть пустым
                        </span>
                        <span ng-show="forgetPass.email.$error.email">введите правильный емейл
                        </span>
                    </p>

                </div>
                <p class="submit cta-button">
                    <button class="btn btn-lg btn-block btn-primary" ng-disabled="forgetPass.$invalid" type="submit">
                        Востановить пароль
                    </button>
                </p>
            </form>
            <p class="submit cta-button">
                <button class="btn btn-lg btn-block btn-primary" ng-click="cancel()">Отмена
                </button>
            </p>

        </div>
    </div>

</div>