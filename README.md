# Neko_channel[DB ver]
A casual message board for carefree chatting🐈

## 概要
Webアプリケーションの開発練習として、簡単な掲示板を作成。
H2データベースを使用し、ログイン画面に新規登録機能を追加。
ユーザ情報や掲示板への投稿内容をデータベースに保存。

また、Webアプリケーション開発時における設計を意識しながら構築。

- ログインに関する機能
- つぶやきに関する機能


## 作成動機
データベースを活用したWebアプリケーション開発の練習のため。
以前のNeko Channelではデータベースを使用せず、アプリケーションスコープとArrayListで作成。
これに対して、データベースを活用しユーザ情報や投稿内容を管理するWebアプリケーションを作成。
両者を比較することで学習効果を高めることを目指す。

## 機能
- **ログイン機能**

新規ユーザーは登録が必要。
登録されたユーザ情報およびパスワードは「User」データベースに保存。

- **ログアウト機能**

- **つぶやき機能**

     - 投稿が空の場合はエラーメッセージを表示。
     - ユーザ名とつぶやき内容を「Mutter」データベースに保存。

- **つぶやき閲覧機能**

     - 全ユーザーのつぶやきを新しい順に表示。
     - 閲覧にはログインが必須（フィルタを実装）。

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
---

## その他
参考書籍:スッキリわかるサーブレット&JSP入門
総復習


