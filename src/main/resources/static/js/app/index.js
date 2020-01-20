var index = {

    init : function(){
        var _this = this;

        // 저장
        $('#btn-save').on('click', function(){
            _this.save();
        });

        // 수정
        $('#btn-update').on('click', function(){
            _this.update();
        });

        // 삭제
        $('#btn-delete').on('click', function(){
            _this.delete();
        });

    },

    /** 저장 */
    save : function(){
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        }

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    /** 수정 */
    update : function(){
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        // REST에서 CRUD
        // HTTP Method (생성 - POST, 읽기 - GET, 수정 - PUT, 삭제 - DELETE)
        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    }

};

index.init();