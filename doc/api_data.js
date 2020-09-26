define({ "api": [
  {
    "type": "GET",
    "url": "/bookapi/book/detail",
    "title": "获取书籍详情",
    "version": "0.1.0",
    "group": "book",
    "name": "bookDetail",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>书籍id,不可为空</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例",
          "content": "{\n    \"id\": \"5ccac5a330aabb4dbed09af9\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回样例",
          "content": "{\n    \"code\": 200,\n    \"message\": \"成功\",\n    \"data\": {\n        \"id\": \"5ccac5a330aabb4dbed09af9\",\n        \"bookName\": \"末世之强制情人\",\n        \"cover\": \"cover/末世之强制情人.jpg\",\n        \"author\": \"跑跑红枣\",\n        \"intro\": \"介绍:    夏庭重生了，以为能和无数小说的主角一样，牛逼哄哄的虐死渣男，斗败小三，修个法术，横行末世。\",\n        \"categoryId\": \"5ccac5a230aabb4dbed09af8\"\n    }\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>错误码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "massage",
            "description": "<p>信息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "data",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/wb/webbook/controller/BookApiController.java",
    "groupTitle": "book"
  },
  {
    "type": "GET",
    "url": "/bookapi/book",
    "title": "获取书籍列表",
    "version": "0.1.0",
    "group": "book",
    "name": "bookList",
    "parameter": {
      "examples": [
        {
          "title": "请求样例",
          "content": "{\n    \"categoryId\": \"\",\n    \"pageSize\": 10,\n    \"pageNum\": 1,\n    \"lastId\": \"\"\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageSize",
            "description": "<p>每页条数</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageNum",
            "description": "<p>页数</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "lastId",
            "description": "<p>该页最后一条的id,首页为空</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回样例",
          "content": "{\n    \"code\": 200,\n    \"message\": \"success\",\n    \"data\": {\n        \"pageNum\": 1,\n        \"pageSize\": 10,\n        \"total\": 5,\n        \"pages\": 1,\n        \"list\": [\n            {\n                \"id\": \"5ccac5a230aabb4dbed09af7\",\n                \"bookName\": \"快穿之青蘅\",\n                \"cover\": \"cover/快穿之青蘅.jpg\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>错误码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "massage",
            "description": "<p>信息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "data",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/wb/webbook/controller/BookApiController.java",
    "groupTitle": "book"
  },
  {
    "type": "GET",
    "url": "/bookapi/category",
    "title": "获取类型列表",
    "version": "0.1.0",
    "group": "category",
    "name": "categoryList",
    "success": {
      "examples": [
        {
          "title": "返回样例",
          "content": "{\n    \"code\": 200,\n    \"message\": \"success\",\n    \"data\": [\n        {\n            \"id\": \"5ccac5bc30aabb4dbed09b83\",\n            \"categoryName\": \"职场校园\"\n        }\n    ]\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>错误码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "massage",
            "description": "<p>信息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "data",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/wb/webbook/controller/BookApiController.java",
    "groupTitle": "category"
  },
  {
    "type": "GET",
    "url": "/bookapi/chapter/content",
    "title": "获取章节内容",
    "version": "0.1.0",
    "group": "chapter",
    "name": "chapterContent",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>章节id,不可为空</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例",
          "content": "{\n    \"id\": \"5ccac5a530aabb4dbed09afa\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回样例：",
          "content": "{\n    \"code\": 200,\n    \"message\": \"success\",\n    \"data\": {\n        \"chapterNumber\": 14,\n        \"chapterName\": \"第14章 风狐\",\n        \"chapterContent\": \"xxxxx\",\n        \"bookId\": \"5ccac5a330aabb4dbed09af9\",\n        \"id\": \"5ccac5a530aabb4dbed09afa\"\n    }\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>错误码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "massage",
            "description": "<p>信息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "data",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/wb/webbook/controller/BookApiController.java",
    "groupTitle": "chapter"
  },
  {
    "type": "POST",
    "url": "/bookapi/chapter",
    "title": "获取章节列表",
    "version": "0.1.0",
    "group": "chapter",
    "name": "chapterList",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "bookId",
            "description": "<p>书籍id,不可为空</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageSize",
            "description": "<p>每页条数</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageNum",
            "description": "<p>页数</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "lastId",
            "description": "<p>该页最后一条的id,首页为空</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求样例",
          "content": "{\n    \"bookId\": \"5ccac5a530aabb4dbed09afc\",\n    \"pageSize\": 10,\n    \"pageNum\": 1,\n    \"lastId\": \"\"\n}",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "返回样例",
          "content": "{\n    \"code\": 200,\n    \"message\": \"success\",\n    \"data\": {\n        \"pageNum\": 1,\n        \"pageSize\": 10,\n        \"total\": 85,\n        \"pages\": 9,\n        \"list\": [\n            {\n                \"chapterNumber\": 48,\n                \"chapterName\": \"第五十章 先进状况救援队\",\n                \"id\": \"5ccac5a630aabb4dbed09afe\"\n            }\n        ]\n    }\n}",
          "type": "json"
        }
      ],
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "int",
            "optional": false,
            "field": "code",
            "description": "<p>错误码</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "massage",
            "description": "<p>信息</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": true,
            "field": "data",
            "description": "<p>内容</p>"
          }
        ]
      }
    },
    "filename": "src/main/java/com/wb/webbook/controller/BookApiController.java",
    "groupTitle": "chapter"
  }
] });
