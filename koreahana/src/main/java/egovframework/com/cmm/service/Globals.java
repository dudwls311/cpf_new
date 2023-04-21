/**
 * @version 3.2.0.1
 */
package egovframework.com.cmm.service;

/**
 *  Class Name : Globals.java
 *  Description : 시스템 구동 시 프로퍼티를 통해 사용될 전역변수를 정의한다.
 *  Modification Information
 *
 *     수정일         수정자                   수정내용
 *   -------    --------    ---------------------------
 *   2009.01.19    박지욱          최초 생성
 *
 *  @author 공통 서비스 개발팀 박지욱
 *  @since 2009. 01. 19
 *  @version 1.0
 *  @see
 *
 */

public class Globals {
	//OS 유형
    public static final String OS_TYPE = EgovProperties.getProperty("Globals.OsType");
    //DB 유형
    public static final String DB_TYPE = EgovProperties.getProperty("Globals.DbType");
    //메인 페이지
    public static final String MAIN_PAGE = EgovProperties.getProperty("Globals.MainPage");
    //ShellFile 경로
    public static final String SHELL_FILE_PATH = EgovProperties.getPathProperty("Globals.ShellFilePath");
    //컨텍스트 경로
    public static final String CONTEXT_PATH = EgovProperties.getProperty("Globals.contextPath");
    
    //퍼로퍼티 파일 위치
    public static final String CONF_PATH = EgovProperties.getPathProperty("Globals.ConfPath");
    //Server정보 프로퍼티 위치
    public static final String SERVER_CONF_PATH = EgovProperties.getPathProperty("Globals.ServerConfPath");
    //Client정보 프로퍼티 위치
    public static final String CLIENT_CONF_PATH = EgovProperties.getPathProperty("Globals.ClientConfPath");
    //파일포맷 정보 프로퍼티 위치
    public static final String FILE_FORMAT_PATH = EgovProperties.getPathProperty("Globals.FileFormatPath");

    //파일 업로드 원 파일명
	public static final String ORIGIN_FILE_NM = "originalFileName";
	//파일 확장자
	public static final String FILE_EXT = "fileExtension";
	//파일크기
	public static final String FILE_SIZE = "fileSize";
	//업로드된 파일명
	public static final String UPLOAD_FILE_NM = "uploadFileName";
	//파일경로
	public static final String FILE_PATH = "filePath";

	//메일발송요청 XML파일경로
	public static final String MAIL_REQUEST_PATH = EgovProperties.getPathProperty("Globals.MailRequestPath");
	//메일발송응답 XML파일경로
	public static final String MAIL_RESPONSE_PATH = EgovProperties.getPathProperty("Globals.MailRResponsePath");

	//CMS 로그인 URL
	public static final String CMS_LOGIN_URL = EgovProperties.getProperty("Globals.CMS.LOGIN_URL");
	
	// G4C 연결용 IP (localhost)
	public static final String LOCAL_IP = EgovProperties.getProperty("Globals.LocalIp");

	//파일 업로드 경로
	public static final String UPLOAD_PATH = EgovProperties.getProperty("Globals.fileStorePath");			//업로드 경로
	
    //기타 업로드 경로
    public static final String ETC_UPLOAD_PATH = EgovProperties.getProperty("Globals.EtcUploadPath");
    
    //서블릿명
    public static final String SERVLET_NAME = EgovProperties.getProperty("GLobals.servletName");
    
    public static final String ACCESS_FILE_EXT = EgovProperties.getProperty("Globals.FILE.EXT");
    public static final String EXT_FILE_THUMBIMG = EgovProperties.getProperty("Globals.FILE.EXT.THUMBIMG");
    public static final String MEMBER_LOGIN_URL = EgovProperties.getProperty("Globals.MEMBER.LOGIN_URL");
    public static final String MEMBER_LOGOUT_URL = EgovProperties.getProperty("Globals.MEMBER.LOGOUT_URL");
    
    //CRON 관련
    public static final String CRON_EXCUTE_SERVER_IP = EgovProperties.getProperty("Globals.CRON.EXCUTE_SERVER_IP");
    public static final String CRON_ALIMI_URL = EgovProperties.getProperty("Globals.CRON.ALIMI_URL");
    public static final String CRON_DISSEMINATE_URL = EgovProperties.getProperty("Globals.CRON.DISSEMINATE_URL");

    //파일고 관련
    public static final String FILEGO_ACTIVE = EgovProperties.getProperty("Globals.FILEGO.ACTIVE");								//파일고 활성화 여부 (on, off)
    public static final String FILEGO_SEND_FILE_URL = EgovProperties.getProperty("Globals.FILEGO.SEND_FILE_URL");				//파일고 파일 전송 URL
    public static final String FILEGO_SEND_DELETE_FILE_URL = EgovProperties.getProperty("Globals.FILEGO.SEND_DELETE_FILE_URL");	//파일고 파일 삭제 URL
    public static final String FILEGO_SEND_RENAME_FILE_URL = EgovProperties.getProperty("Globals.FILEGO.SEND_RENAME_FILE_URL");	//파일고 파일 리네임 RUL
    public static final String FILEGO_CONTENT_SENDYN = EgovProperties.getProperty("Globals.FILEGO.TYPE.CONTENT.SENDYN");		//파일고 콘텐츠파일 유형 파일전송 여부
    public static final String FILEGO_UPLOAD_SENDYN = EgovProperties.getProperty("Globals.FILEGO.TYPE.UPLOAD.SENDYN");			//파일고 업로드파일 유형 파일전송 여부
    public static final String FILEGO_CONFIG_SENDYN = EgovProperties.getProperty("Globals.FILEGO.TYPE.CONFIG.SENDYN");			//파일고 설정파일 유형 파일전송 여부
    public static final String FILEGO_BOARD_SENDYN = EgovProperties.getProperty("Globals.FILEGO.TYPE.BOARD.SENDYN");			//파일고 게시판파일 유형 파일전송 여부
    public static final String FILEGO_CRON_SENDYN = EgovProperties.getProperty("Globals.FILEGO.TYPE.CRON.SENDYN");				//파일고 크론파일 유형 파일전송 여부

    //로그인 관련
    public static final String CRON_LOGIN_UNCLOCK_ACTIVE = EgovProperties.getProperty("Globals.CRON.LOGIN.UNCLOCK.ACTIVE");		//로그인 틀린횟수 CRON 사용여부
    public static final String CRON_LOGIN_UNCLOCK_TIMER = EgovProperties.getProperty("Globals.CRON.LOGIN.UNCLOCK.TIMER");		//로그인 틀린횟수 CRON 규칙
    public static final String LOGIN_UNCLOCK_TIME = EgovProperties.getProperty("Globals.LOGIN.UNCLOCK.TIME");					//로그인 틀린횟수 초기화 시간
    public static final String LOGIN_PW_MISS_MAX_COUNT = EgovProperties.getProperty("Globals.LOGIN.PW.MISS.MAX.COUNT");			//로그인 틀린횟수 최대치
    
    //ADDON
    public static final String SYNC_PROTOCOL_SERVER_PORT = EgovProperties.getProperty("Globals.SYNC.PROTOCOL_SERVER_PORT");		//동기화 서버(콤마 구분)
    public static final String SYNC_URI = EgovProperties.getProperty("Globals.SYNC.URI");						//동기화 URI
    public static final String SYNC_CONN_TIME = EgovProperties.getProperty("Globals.SYNC.CONN_TIME");					//1000=1초
    public static final String SYNC_READ_TIME = EgovProperties.getProperty("Globals.SYNC.READ_TIME");					//1000=1초
    public static final String SYNC_MAX_CONN_TOTAL = EgovProperties.getProperty("Globals.SYNC.MAX_CONN_TOTAL");			//maxConnTotal은 연결을 유지할 최대 숫자
    public static final String SYNC_MAX_CONN_PER_ROUTE = EgovProperties.getProperty("Globals.SYNC.MAX_CONN_PER_ROUTE");	//maxConnPerRoute는 특정 경로당 최대 숫자
    
    //실명인증관련
    public static final String REALAUTH_TYPE = EgovProperties.getProperty("Globals.realauth.type");							//실명인증 구분(nice,)
    public static final String NICE_SITECODE = EgovProperties.getProperty("Globals.realauth.nice.sitecode");				//nice sitecode
    public static final String NICE_SITEPASSWORD = EgovProperties.getProperty("Globals.realauth.nice.sitepassword");		//nice sitepassword
    public static final String NICE_IPIN_SITECODE = EgovProperties.getProperty("Globals.realauth.nice.ipin.sitecode");		//nice ipin sitecode
    public static final String NICE_IPIN_SITEPASSWORD = EgovProperties.getProperty("Globals.realauth.nice.ipin.sitepassword");	//nice ipin sitepassword
    
    //내부망아이피리스트
    public static final String TNET_IPS = EgovProperties.getProperty("Globals.TNET.ips");

    //디지털원패스
    public static final String ONEPASS_LOGIN_FORWARD = EgovProperties.getProperty("Globals.ONEPASS.login.forward");//login forward url

    //juso.go.kr 관련
    public static final String JUSO_KEY = EgovProperties.getProperty("Globals.JUSO.key");//api key
    
    //file 암호화함수 키
    public static final String FILE_SCR_KEY = EgovProperties.getProperty("Globals.FILE.scrKey");
    //file 복호화될 파일 경로
    public static final String FILE_DEC_PATH = EgovProperties.getProperty("Globals.FILE.decFileStorePath");
    //file 복호화된 파일에 추가로 붇는 확장자명
    public static final String FILE_DEC_ADD_EXT_NAME = EgovProperties.getProperty("Globals.FILE.decAddExtName");
    
    
    //SMS
    public static final String SMS_USER_NAME = EgovProperties.getProperty("Globals.ciel.UserName");		//시스템계정
    public static final String SMS_SYSTEM_CODE = EgovProperties.getProperty("Globals.ciel.SystemCode");	//시스템코드
    public static final String SMS_SUB_CODE = EgovProperties.getProperty("Globals.ciel.SubCode");		//시스템하위코드
    public static final String SMS_SEND_NUMBER = EgovProperties.getProperty("Globals.ciel.SendNumber");	//발신번호

    //연계서버
    public static final String RELAY_SERVER = EgovProperties.getProperty("Globals.RELAY.server");
    //연계url - 디지털원패스
    public static final String RELAY_URL_ONEPASS_GET_REQUEST_HANDLER_VALUES = EgovProperties.getProperty("Globals.RELAY.url.onepass.getRequestHandlerValues");
    public static final String RELAY_URL_ONEPASS_RESPONSE_HANDLER_CHECK = EgovProperties.getProperty("Globals.RELAY.url.onepass.responseHandlerCheck");
    public static final String RELAY_URL_ONEPASS_FIND_USER = EgovProperties.getProperty("Globals.RELAY.url.onepass.findUser");
    public static final String RELAY_URL_ONEPASS_INTER_LOCK_RELEASE = EgovProperties.getProperty("Globals.RELAY.url.onepass.interLockRelease");

    //GPKIAPI
    public static final String GPKIAPI_DOMAIN = EgovProperties.getProperty("Globals.GPKIAPI.domain");
    public static final String GPKIAPI_URI = EgovProperties.getProperty("GLobals.GPKIAPI.uri");
    public static final String GPKIAPI_KEY = EgovProperties.getProperty("Globals.GPKIAPI.key");
    public static final String GPKIAPI_WORKDIR = EgovProperties.getProperty("Globals.GPKIAPI.workdir");
    public static final String GPKIAPI_MY_SERVER_ID = EgovProperties.getProperty("Globals.GPKIAPI.myServerId");
    public static final String GPKIAPI_TARGET_SERVER_ID = EgovProperties.getProperty("Globals.GPKIAPI.targetServerId");
    public static final String GPKIAPI_MOCK_YN = EgovProperties.getProperty("Globals.GPKIAPI.mockYn");
    public static final String GPKIAPI_GPKI_YN = EgovProperties.getProperty("Globals.GPKIAPI.gpkiYn");
    public static final String GPKIAPI_LIC_PATH = EgovProperties.getProperty("Globals.GPKIAPI.gpkiLicPath");
    public static final String GPKIAPI_CERT_FILE_PATH = EgovProperties.getProperty("Globals.GPKIAPI.certFilePath");
    public static final String GPKIAPI_ENV_CERT_FILE_PATH_NAME = EgovProperties.getProperty("Globals.GPKIAPI.envCertFilePathName");
    public static final String GPKIAPI_ENV_PRIVATE_KEY_FILE_PATH_NAME = EgovProperties.getProperty("Globals.GPKIAPI.envPrivateKeyFilePathName");
    public static final String GPKIAPI_ENV_PRIVATE_KEY_PASSWD = EgovProperties.getProperty("Globals.GPKIAPI.envPrivateKeyPasswd");
    public static final String GPKIAPI_SIG_CERT_FILE_PATH_NAME = EgovProperties.getProperty("Globals.GPKIAPI.sigCertFilePathName");
    public static final String GPKIAPI_SIG_PRIVATE_KEY_FILE_PATH_NAME = EgovProperties.getProperty("Globals.GPKIAPI.sigPrivateKeyFilePathName");
    public static final String GPKIAPI_SIG_PRIVATE_KEY_PASSWD = EgovProperties.getProperty("Globals.GPKIAPI.sigPrivateKeyPasswd");
    public static final String GPKIAPI_IS_LDAP = EgovProperties.getProperty("Globals.GPKIAPI.isLDAP");
    public static final String GPKIAPI_TEST_GPKI = EgovProperties.getProperty("Globals.GPKIAPI.testGPKI");
    public static final String GPKIAPI_LDAP_ADDRESS = EgovProperties.getProperty("Globals.GPKIAPI.ldapAddress");

    //SMS AUTH
    public static final String SMS_AUTH_SEND_NUMBER = EgovProperties.getProperty("Globals.SMS_AUTH.sendNumber");
    public static final String SMS_AUTH_SEND_TITLE = EgovProperties.getProperty("Globals.SMS_AUTH.sendTitle");
    public static final String SMS_AUTH_USE_YN = EgovProperties.getProperty("Globals.SMS_AUTH.useYn");
    public static final String SMS_AUTH_REQUEST_SECOND = EgovProperties.getProperty("Globals.SMS_AUTH.requestSecond");
    public static final String SMS_AUTH_INVALID_SECOND = EgovProperties.getProperty("Globals.SMS_AUTH.invalidSecond");
    
    //FASOO
    public static final String FASOO_USE_YN = EgovProperties.getProperty("Globals.FASOO.useYn");
    public static final String FASOO_FSDINIT_PATH = EgovProperties.getProperty("Globals.FASOO.fsdInitPath");
    public static final String FASOO_CPID = EgovProperties.getProperty("Globals.FASOO.CPID");
    public static final String FASOO_CLIENT_CODE = EgovProperties.getProperty("Globals.FASOO.clientCode");
    
}
