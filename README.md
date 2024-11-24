# Neko_channel[DB ver]
A casual message board for carefree chatting🐈

## 概要
WEBアプリケーションの開発練習として簡単な掲示板を作成。
h2データベースを使用し、ユーザーのログイン画面にて新規登録ページを追加。
ユーザの情報や掲示板に投稿されたテキストは各データベースに格納。

また、webアプリケーション開発時においての設計というところも意識しながら作成しました。


- ログインに対する機能
- つぶやきに対する機能


## 作成動機
DBを使用したwebアプリケーションの開発練習の為。
Neko channelにてDBは使用せずにアプリケーションスコープとArrayListを使用した。
それに対して、ユーザの情報と、投稿によるつぶやき情報を保存するDBを使用してのwebアプリケーションとを両方作成し、学習の際に見比べられるようにしようと思いました。

## 機能
- **ログイン機能**

新規での利用は、新規登録をする必要があり。
新規登録時のユーザ情報及びパスワードは「User」データベースに保存。

- **ログアウト機能**

- **つぶやき機能**

投稿が空の場合には投稿を受けずにエラーメッセージの表示。
つぶやきはユーザ名と、つぶやき内容をデータベース「Mutter」に保存する。

- **つぶやき閲覧機能**

全ユーザのつぶやきを新しいものから順に表示。
閲覧機能を使用するにはログイン状態である必要がある。（フィルターの作成）

---

## 処理の流れ図


## directory図
```
.
└── Neko_channel/
    ├── java/
    │   ├── servlet/
    │   │   ├── Login.java
    │   │   ├── Logout.java
    │   │   └── Main.java
    │   ├── model /
    │   │   ├── LoginLogic.java
    │   │   ├── PostMutterLogic.java
    │   │   ├── GetMutterListLogic.java
    │   │   ├── User.java(javaBeans)
    │   │   └── Mutter.java(javaBeans)
    │   └── dao/
    │       └── MuttersDAO.java
    └── webapp/
        ├── css
        ├── images
        ├── WEB-INF/
        │   └── jsp /
        │       ├── loginResult.jsp
        │       ├── logout.jsp
        │       └── main.jsp
        └── index.jsp
```

## その他
参考書籍:スッキリわかるサーブレット&JSP入門
総復習


