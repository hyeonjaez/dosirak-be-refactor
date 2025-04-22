package com.example.dosirakbe.global.exception;

import com.github.hyeonjaez.springcommon.exception.ErrorCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;


/**
 * packageName    : com.example.dosirakbe.global.util<br>
 * fileName       : ExceptionEnum<br>
 * author         : femmefatalehaein<br>
 * date           : 10/13/24<br>
 * description    : 애플리케이션에서 발생하는 예외 정보를 정의한 열거형 클래스입니다.<br>
 * ===========================================================<br>
 * DATE              AUTHOR             NOTE<br>
 * -----------------------------------------------------------<br>
 * 10/13/24        femmefatalehaein                최초 생성<br>
 */
@ToString
public enum ExceptionEnum implements ErrorCode {

    /**
     * 보안 관련 예외.
     * <p>HTTP 상태: {@code UNAUTHORIZED} (401)</p>
     */
    SECURITY(HttpStatus.UNAUTHORIZED, "CE0001", "로그인이 필요합니다"),
    /**
     * 권한 부족 예외.
     * <p>HTTP 상태: {@code FORBIDDEN} (403)</p>
     */
    PERMISSION_DENIED(HttpStatus.FORBIDDEN, "CE0003", "권한이 없습니다"),

    DUPLICATE_IMAGE(HttpStatus.BAD_REQUEST, "IMAGE-001", "중복된 이미지가 업로드되었습니다."),

    /**
     * 이미지가 존재하지 않을 때 발생하는 예외.
     * <p>HTTP 상태: {@code NOT_FOUND} (404)</p>
     */
    NO_IMAGE_EXIST(HttpStatus.NOT_FOUND, "IMAGE-002", "이미지가 존재하지 않습니다."),

    /**
     * 파일 삭제 실패 예외.
     * <p>HTTP 상태: {@code INTERNAL_SERVER_ERROR} (500)</p>
     */
    FAIL_DELETE(HttpStatus.INTERNAL_SERVER_ERROR, "IMAGE-003", "파일 삭제에 실패했습니다."),

    /**
     * 파일 업로드 실패 예외.
     * <p>HTTP 상태: {@code INTERNAL_SERVER_ERROR} (500)</p>
     */
    FAIL_UPLOAD(HttpStatus.INTERNAL_SERVER_ERROR, "IMAGE-004", "파일 업로드에 실패했습니다."),

    /**
     * 허용되지 않는 파일 확장자 예외.
     * <p>HTTP 상태: {@code BAD_REQUEST} (400)</p>
     */
    NOT_IMAGE_EXTENSION(HttpStatus.BAD_REQUEST, "IMAGE-005", "허용되지 않는 파일 확장자입니다."),

    /**
     * 잘못된 요청 예외.
     * <p>HTTP 상태: {@code BAD_REQUEST} (400)</p>
     */
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "CE0004", "잘못된 요청입니다"),

    /**
     * 유효하지 않은 Access Token 예외.
     * <p>HTTP 상태: {@code UNAUTHORIZED} (401)</p>
     */
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "CE0009", "유효하지 않은 accessToken입니다."),

    /**
     * 중복된 닉네임 예외.
     * <p>HTTP 상태: {@code BAD_REQUEST} (400)</p>
     */
    DUPLICATE_NICKNAME(HttpStatus.BAD_REQUEST, "CE00010", "중복된 닉네임입니다"),
    /// ///////
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-001", "해당 user 를 찾을 수 없습니다."),

    ACTIVITY_LOG_INVALID_REQUEST(HttpStatus.BAD_REQUEST, "ACTIVITY_LOG-001", "activity-log 생성시 유효하지 않은 값이 왔습니다."),

    ZONE_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "ZONE_CATEGORY-001", "해당 zone category 를 찾을 수 없습니다."),

    CHAT_ROOM_DUPLICATE(HttpStatus.CONFLICT, "CHAT_ROOM-001", "이미 해당 chatroom 에 참여되어 있습니다."),
    CHAT_ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "CHAT_ROOM-002", "해당 chatroom 를 찾을 수 없습니다."),
    CHAT_ROOM_INVALID_REQUEST(HttpStatus.BAD_REQUEST, "CHAT_ROOM-003", "chatroom 의 request 데이터의 유효성이 허용되지 않습니다."),

    USER_CHAT_ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_CHAT_ROOM-001", "해당 user chat room 를 찾을 수 없습니다."),
    USER_CHAT_ROOM_NOT_EXISTS(HttpStatus.BAD_REQUEST, "USER_CHAT_ROOM-002", "해당 유저는 해당하는 chat room 에 들어가 있지 않습니다."),

    ELITE_INFO_NOT_FOUND(HttpStatus.NOT_FOUND, "ELITE_INFO-001", "해당하는 userId 의 Elite info 가 없습니다."),

    MESSAGE_INVALID_REQUEST(HttpStatus.BAD_REQUEST, "MESSAGE-001", "message 의 request 데이터의 유효성이 허용되지 않습니다."),

    SALE_STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "SALE_STORE-001", "해당하는 sale store 가 없습니다."),

    STORE_INVALID_REQUEST(HttpStatus.BAD_REQUEST, "STORE-001", "STORE 의 request 데이터의 유효성 검사를 실패했습니다."),
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE-002", "해당하는 store 가 없습니다."),

    TRACK_INVALID_REQUEST(HttpStatus.BAD_REQUEST, "TRACK-001", "요청하신 거리가 유효하지 않은 값입니다."),


    ;
    private final HttpStatus status;
    private final String code;
    private final String message;

    /**
     * 메시지가 있는 {@link ExceptionEnum}을 생성합니다.
     *
     * @param status  HTTP 상태 코드
     * @param code    에러 코드
     * @param message 기본 메시지
     */
    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
