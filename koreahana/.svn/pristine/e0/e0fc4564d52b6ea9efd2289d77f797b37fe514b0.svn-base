/* 마이그레이션을 위한 테이블 */
/*
DROP TABLE TB_MIGRATION;
CREATE TABLE TB_MIGRATION (
	A VARCHAR2(4000) NULL,
	B VARCHAR2(4000) NULL,
	C VARCHAR2(4000) NULL,
	D VARCHAR2(4000) NULL,
	E VARCHAR2(4000) NULL,
	F VARCHAR2(4000) NULL,
	G VARCHAR2(4000) NULL,
	H VARCHAR2(4000) NULL,
	I VARCHAR2(4000) NULL,
	J VARCHAR2(4000) NULL,
	K VARCHAR2(4000) NULL,
	L VARCHAR2(4000) NULL,
	M VARCHAR2(4000) NULL,
	N VARCHAR2(4000) NULL,
	O VARCHAR2(4000) NULL,
	P VARCHAR2(4000) NULL,
	Q VARCHAR2(4000) NULL,
	R VARCHAR2(4000) NULL,
	S VARCHAR2(4000) NULL,
	T VARCHAR2(4000) NULL,
	U VARCHAR2(4000) NULL,
	V VARCHAR2(4000) NULL,
	W VARCHAR2(4000) NULL,
	X VARCHAR2(4000) NULL,
	Y VARCHAR2(4000) NULL,
	Z VARCHAR2(4000) NULL,
	
	A_A VARCHAR2(4000) NULL,
	A_B VARCHAR2(4000) NULL,
	A_C VARCHAR2(4000) NULL,
	A_D VARCHAR2(4000) NULL,
	A_E VARCHAR2(4000) NULL,
	A_F VARCHAR2(4000) NULL,
	A_G VARCHAR2(4000) NULL,
	A_H VARCHAR2(4000) NULL,
	A_I VARCHAR2(4000) NULL,
	A_J VARCHAR2(4000) NULL,
	A_K VARCHAR2(4000) NULL,
	A_L VARCHAR2(4000) NULL,
	A_M VARCHAR2(4000) NULL,
	A_N VARCHAR2(4000) NULL,
	A_O VARCHAR2(4000) NULL,
	A_P VARCHAR2(4000) NULL,
	A_Q VARCHAR2(4000) NULL,
	A_R VARCHAR2(4000) NULL,
	A_S VARCHAR2(4000) NULL,
	A_T VARCHAR2(4000) NULL,
	A_U VARCHAR2(4000) NULL,
	A_V VARCHAR2(4000) NULL,
	A_W VARCHAR2(4000) NULL,
	A_X VARCHAR2(4000) NULL,
	A_Y VARCHAR2(4000) NULL,
	A_Z VARCHAR2(4000) NULL,
	
	B_A VARCHAR2(4000) NULL,
	B_B VARCHAR2(4000) NULL,
	B_C VARCHAR2(4000) NULL,
	B_D VARCHAR2(4000) NULL,
	B_E VARCHAR2(4000) NULL,
	B_F VARCHAR2(4000) NULL,
	B_G VARCHAR2(4000) NULL,
	B_H VARCHAR2(4000) NULL,
	B_I VARCHAR2(4000) NULL,
	B_J VARCHAR2(4000) NULL,
	B_K VARCHAR2(4000) NULL,
	B_L VARCHAR2(4000) NULL,
	B_M VARCHAR2(4000) NULL,
	B_N VARCHAR2(4000) NULL,
	B_O VARCHAR2(4000) NULL,
	B_P VARCHAR2(4000) NULL,
	B_Q VARCHAR2(4000) NULL,
	B_R VARCHAR2(4000) NULL,
	B_S VARCHAR2(4000) NULL,
	B_T VARCHAR2(4000) NULL,
	B_U VARCHAR2(4000) NULL,
	B_V VARCHAR2(4000) NULL,
	B_W VARCHAR2(4000) NULL,
	B_X VARCHAR2(4000) NULL,
	B_Y VARCHAR2(4000) NULL,
	B_Z VARCHAR2(4000) NULL
);
*/


--미래행복통장(신규)
delete from TB_FTHPBB_NEW_APLY WHERE FTHPBB_NEW_APLY_SN >= 1000;
INSERT INTO TB_FTHPBB_NEW_APLY (
	FTHPBB_NEW_APLY_SN		,
	FLNM		,
	GENDER_CD		,
	RRNO		,
	AGE_CD		,
	MBPHNO		,
	CTPV_CD		,
	SGG_CD		,
	ECNMAT_CD		,
	CR_CD		,
	CO_NM		,
	EMPLIS_JOIN_YMD		,
	SALARY_AMT		,
	ENTCNY_YMD		,
	ENTISC_YMD		,
	TRINS_EXPRY_YMD		,
	RCPT_YMD		,
	JRDC_HANACT_NM		,
	DCSN_SPRT_AMT		,
	BB_JOIN_YMD		,
	SAVING_DDLN_YMD		,
	PRTPRD_EXTSN_CD		,
	IDTPRS_SAVING_AMT_ACTNO		,
	STMCHK_ACTNO		,
	RMRK		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                         /*FTHPBB_NEW_APLY_SN*/
	, FN_CRYPTO_ENC(NVL(D, '-'),'M_KEY')                                             /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = G), '-')        /*GENDER_CD*/
	, FN_CRYPTO_ENC(REPLACE(NVL(E, '@'),'-',''),'M_KEY')                             /*RRNO*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = F), '-')        /*AGE_CD*/
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')                                             /*MBPHNO*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')        /*CTPV_CD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = J), '-')        /*SGG_CD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = K), '-')        /*ECNMAT_CD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = L), '-')        /*CR_CD*/
	, NVL(M, '-')                                                                    /*CO_NM*/
	, NVL(N, '-')                                                                    /*EMPLIS_JOIN_YMD*/
	, NVL(O, '0')                                                                    /*SALARY_AMT*/
	, REPLACE(REPLACE(NVL(R, '19800101'),'-',''),'.','')                             /*ENTCNY_YMD*/
	, REPLACE(REPLACE(NVL(S, '19800101'),'-',''),'.','')                             /*ENTISC_YMD*/
	, REPLACE(REPLACE(NVL(T, '19800101'),'-',''),'.','')                             /*TRINS_EXPRY_YMD*/
	, REPLACE(REPLACE(NVL(C, '19800101'),'-',''),'.','')	                         /*RCPT_YMD*/
	, NVL(Q, '-')                                                                    /*JRDC_HANACT_NM*/
	, NVL(P, '0')                                                                    /*DCSN_SPRT_AMT*/
	, REPLACE(REPLACE(NVL(U, '19800101'),'-',''),'.','')                             /*BB_JOIN_YMD*/
	, REPLACE(REPLACE(NVL(V, '19800101'),'-',''),'.','')                             /*SAVING_DDLN_YMD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = W), '-')        /*PRTPRD_EXTSN_CD*/
	, NVL(X, '-')                                                                    /*IDTPRS_SAVING_AMT_ACTNO*/
	, NVL(Y, '-')                                                                    /*STMCHK_ACTNO*/
	, Z                                                                              /*RMRK*/
	, '16002'                                                                        /*SPRT_STTS_CD*/
	, NULL                                                                           /*RSN*/
	, 'MBR_0000000064'                                                               /*RGTR_ID*/
	, 'MBR_0000000064'                                                               /*MDFR_ID*/
	, SYSDATE                                                                        /*REG_DT*/
	, SYSDATE                                                                        /*MDFCN_DT*/
	, 'N'                                                                            /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'FTH_NEW';

--미래행복통장(만기)
delete from TB_FTHPBB_MTRY_CNCLTN WHERE FTHPBB_MTRY_CNCLTN_SN >= 1000;
INSERT INTO TB_FTHPBB_MTRY_CNCLTN (
	FTHPBB_MTRY_CNCLTN_SN		,
	FLNM		,
	RRNO		,
	MBPHNO		,
	CTPV_CD		,
	SGG_CD		,
	RCPT_YMD		,
	CNCLTN_YMD		,
	JRDC_HANACT_NM		,
	BB_JOIN_YMD		,
	USDUSG_CD		,
	IDTPRS_SAVING_AMT		,
	FNDT_SAVING_AMT		,
	MTRY_MM_CNT		,
	FNC_EDU_TKCLS_YMD		,
	IDTPRS_SAVING_AMT_ACTNO		,
	STMCHK_ACTNO		,
	RMRK		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                      /*FTHPBB_MTRY_CNCLTN_SN*/
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                          /*FLNM*/
	, FN_CRYPTO_ENC(REPLACE(NVL(F, '.'),'-',''),'M_KEY')                          /*RRNO*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')		                                  /*MBPHNO*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = H), '-')     /*CTPV_CD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')     /*SGG_CD*/
	, REPLACE(REPLACE(NVL(C, '19800101'),'-',''),'.','')                          /*RCPT_YMD*/
	, REPLACE(REPLACE(NVL(D, '19800101'),'-',''),'.','')                          /*CNCLTN_YMD*/
	, NVL(J, '-')                                                                 /*JRDC_HANACT_NM*/
	, REPLACE(REPLACE(NVL(K, '19800101'),'-',''),'.','')                          /*BB_JOIN_YMD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = L), '-')     /*USDUSG_CD*/
	, NVL(M, '0')                                                                 /*IDTPRS_SAVING_AMT*/
	, NVL(N, '0')                                                                 /*FNDT_SAVING_AMT*/
	, NVL(O, '0')                                                                 /*MTRY_MM_CNT*/
	, REPLACE(REPLACE(NVL(P, '19800101'),'-',''),'.','')                          /*FNC_EDU_TKCLS_YMD*/
	, NVL(Q, '-')                                                                 /*IDTPRS_SAVING_AMT_ACTNO*/
	, NVL(R, '-')                                                                 /*STMCHK_ACTNO*/
	, S                                                                           /*RMRK*/
	, '16002'                                                                     /*SPRT_STTS_CD*/
	, NULL                                                                        /*RSN*/
	, 'MBR_0000000064'                                                            /*RGTR_ID*/
	, 'MBR_0000000064'                                                            /*MDFR_ID*/
	, SYSDATE                                                                     /*REG_DT*/
	, SYSDATE                                                                     /*MDFCN_DT*/
	, 'N'                                                                         /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'FTH_MTR';


--미래행복통장(중도)
delete from TB_FTHPBB_MDW_CNCLTN WHERE FTHPBB_MDW_CNCLTN_SN >= 1000;
INSERT INTO TB_FTHPBB_MDW_CNCLTN (
	FTHPBB_MDW_CNCLTN_SN		,
	FLNM		,
	RRNO		,
	MBPHNO		,
	CTPV_CD		,
	SGG_CD		,
	RCPT_YMD		,
	CNCLTN_YMD		,
	JRDC_HANACT_NM		,
	HANACT_PIC		,
	BB_JOIN_YMD		,
	JOIN_PERIOD_MM_CNT		,
	CNCLTN_RSN_CD		,
	IDTPRS_SAVING_AMT		,
	FNDT_SAVING_AMT		,
	IDTPRS_SAVING_AMT_ACTNO		,
	STMCHK_ACTNO		,
	RMRK		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                          /*FTHPBB_MDW_CNCLTN_SN*/
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                              /*FLNM*/
	, FN_CRYPTO_ENC(REPLACE(NVL(F, '.'),'-',''),'M_KEY')                              /*RRNO*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                              /*MBPHNO*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = H), '-')         /*CTPV_CD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')         /*SGG_CD*/
	, REPLACE(REPLACE(NVL(C, '19800101'),'-',''),'.','')                              /*RCPT_YMD*/
	, REPLACE(REPLACE(NVL(D, '19800101'),'-',''),'.','')                              /*CNCLTN_YMD*/
	, NVL(J, '-')                                                                     /*JRDC_HANACT_NM*/
	, NVL(K, '-')                                                                     /*HANACT_PIC*/
	, REPLACE(REPLACE(NVL(L, '19800101'),'-',''),'.','')                              /*BB_JOIN_YMD*/
	, NVL(M, '0')                                                                     /*JOIN_PERIOD_MM_CNT*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = N), '-')         /*CNCLTN_RSN_CD*/
	, NVL(O, '0')                                                                     /*IDTPRS_SAVING_AMT*/
	, NVL(P, '0')                                                                     /*FNDT_SAVING_AMT*/
	, NVL(Q, '-')                                                                     /*IDTPRS_SAVING_AMT_ACTNO*/
	, NVL(R, '-')                                                                     /*STMCHK_ACTNO*/
	, S                                                                               /*RMRK*/
	, '16002'                                                                         /*SPRT_STTS_CD*/
	, NULL                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                /*MDFR_ID*/
	, SYSDATE                                                                         /*REG_DT*/
	, SYSDATE                                                                         /*MDFCN_DT*/
	, 'N'                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'FTH_MDW';


--의료비
delete from TB_MDLCR_SPRT WHERE MDLCR_SPRT_SN >= 1000;
INSERT INTO TB_MDLCR_SPRT (
	MDLCR_SPRT_SN		,
	FLNM		,
	GENDER_CD		,
	ENTCNY_YM		,
	BRDT_YMD		,
	ADDR		,
	TELNO		,
	DSS_SE_CD		,
	CURE_PERIOD		,
	HSPTL_NM		,
	SPRT_AMT		,
	SPRT_YMD		,
	SPRT_SE_CD		,
	SPRT_STTS_CD		,
	RSN		,
	DSS_NM		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                           /*MDLCR_SPRT_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                               /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = D), '-')          /*GENDER_CD*/
	, REPLACE(REPLACE(NVL(E, '19800101'),'-',''),'.','')                               /*ENTCNY_YM*/
	, FN_CRYPTO_ENC(REPLACE(REPLACE(NVL(F, '19800101'),'-',''),'.',''),'M_KEY')        /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                               /*ADDR*/
	, NVL(H, '-')                                                                      /*TELNO*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')          /*DSS_SE_CD*/
	, J||' ~ '||K                                                                      /*CURE_PERIOD*/
	, NVL(L, '-')                                                                      /*HSPTL_NM*/
	, NVL(N, '0')                                                                      /*SPRT_AMT*/
	, REPLACE(REPLACE(NVL(O, '19800101'),'-',''),'.','')                               /*SPRT_YMD*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P), '-')          /*SPRT_SE_CD*/
	, '16002'                                                                          /*SPRT_STTS_CD*/
	, NULL                                                                             /*RSN*/
	, NVL(M, '-')                                                                      /*DSS_NM*/
	, 'MBR_0000000064'                                                                 /*RGTR_ID*/
	, 'MBR_0000000064'                                                                 /*MDFR_ID*/
	, SYSDATE                                                                          /*REG_DT*/
	, SYSDATE                                                                          /*MDFCN_DT*/
	, 'N'                                                                              /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'MDL';


--경영개선지원금
DELETE FROM TB_MGMIPV_AMT_SPRT WHERE MGMIPV_AMT_SPRT_SN > 1000;
INSERT INTO TB_MGMIPV_AMT_SPRT (
	MGMIPV_AMT_SPRT_SN		,
	FLNM		,
	BRDT_YMD		,
	RRNO_BKNB		,
	HNW_CYCL		,
	MBPHNO		,
	CONM		,
	BZSTAT_CD		,
	BZSTAT_OSD		,
	TPBIZ_NM		,
	BRNO		,
	BIZ_START_YMD		,
	ADDR		,
	CARMDL_CD		,
	MLG		,
	VHCL_MDYR		,
	RCMT_FLD_CD		,
	SPRT_YR		,
	DCSN_AMT		,
	PRCHS_DSCTN		,
	PRCHS_AMT		,
	GIVE_AMT		,
	GIVE_CYCL		,
	RMRK		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                              /*MGMIPV_AMT_SPRT_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                  /*FLNM*/
	, FN_CRYPTO_ENC(REPLACE(REPLACE(NVL(D, '19800101'),'-',''),'.',''),'M_KEY')           /*BRDT_YMD*/
	, NVL(E, '-')                                                                         /*RRNO_BKNB*/
	, NVL(F, '-')                                                                         /*HNW_CYCL*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                                  /*MBPHNO*/
	, NVL(H, '-')                                                                         /*CONM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')             /*BZSTAT_CD*/
	, NVL(J, '-')                                                                         /*BZSTAT_OSD*/
	, NVL(K, '-')                                                                         /*TPBIZ_NM*/
	, REPLACE(REPLACE(NVL(L, '-'),'-',''),'.','')                                         /*BRNO*/
	, REPLACE(REPLACE(NVL(M, '19800101'),'-',''),'.','')                                  /*BIZ_START_YMD*/
	, FN_CRYPTO_ENC(NVL(N, '-'),'M_KEY')                                                  /*ADDR*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = O), '-')             /*CARMDL_CD*/
	, NVL(P, '0')                                                                         /*MLG*/
	, NVL(Q, '-')                                                                         /*VHCL_MDYR*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = R), '-')             /*RCMT_FLD_CD*/
	, NVL(S, '1980')                                                                      /*SPRT_YR*/
	, NVL(T, '0')                                                                         /*DCSN_AMT*/
	, NVL(U, '-')                                                                         /*PRCHS_DSCTN*/
	, NVL(V, '0')                                                                         /*PRCHS_AMT*/
	, NVL(W, '0')                                                                         /*GIVE_AMT*/
	, NVL(X, '0')                                                                         /*GIVE_CYCL*/
	, Y                                                                                   /*RMRK*/
	, '16002'                                                                             /*SPRT_STTS_CD*/
	, NULL                                                                                /*RSN*/
	, 'MBR_0000000064'                                                                    /*RGTR_ID*/
	, 'MBR_0000000064'                                                                    /*MDFR_ID*/
	, SYSDATE                                                                             /*REG_DT*/
	, SYSDATE                                                                             /*MDFCN_DT*/
	, 'N'                                                                                 /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'MGM';


--영농정착
DELETE FROM TB_FRM_SPFST WHERE FRM_SPFST_SN > 1000;
INSERT INTO TB_FRM_SPFST (
	FRM_SPFST_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	PRTDCS_YMD		,
	ENTCNY_YMD		,
	ADDR		,
	FRSCPK_EDU		,
	NEW_YN		,
	SPRT_YR		,
	SPRT_CYCL		,
	SPRT_DCSN_AMT		,
	SPRT_AMT		,
	PRCHS_BZENTY		,
	PRCHS_ITEM		,
	RMRK		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                                  /*FRM_SPFST_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                      /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = D), '-')                 /*GENDER_CD*/
	, FN_CRYPTO_ENC(REPLACE(REPLACE(NVL(E, '19800101'),'-',''),'.',''),'M_KEY')               /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')                                                      /*MBPHNO*/
	, REPLACE(REPLACE(NVL(G, '19800101'),'-',''),'.','')                                      /*PRTDCS_YMD*/
	, REPLACE(REPLACE(NVL(F, '19800101'),'-',''),'.','')                                      /*ENTCNY_YMD*/
	, FN_CRYPTO_ENC(NVL(I, '-'),'M_KEY')                                                      /*ADDR*/
	, NVL(J, '-')                                                                             /*FRSCPK_EDU*/
	, DECODE(K, '기존', 'N', DECODE(K, '신규', 'Y', '-'))                                       /*NEW_YN*/
	, NVL(L, '-')                                                                             /*SPRT_YR*/
	, NVL(M, '0')                                                                             /*SPRT_CYCL*/
	, NVL(N, '0')                                                                             /*SPRT_DCSN_AMT*/
	, NVL(O, '0')                                                                             /*SPRT_AMT*/
	, NVL(Q, '-')                                                                             /*PRCHS_BZENTY*/
	, NVL(R, '-')                                                                             /*PRCHS_ITEM*/
	, S                                                                                       /*RMRK*/
	, '16002'                                                                                 /*SPRT_STTS_CD*/
	, NULL                                                                                    /*RSN*/
	, 'MBR_0000000064'                                                                        /*RGTR_ID*/
	, 'MBR_0000000064'                                                                        /*MDFR_ID*/
	, SYSDATE                                                                                 /*REG_DT*/
	, SYSDATE                                                                                 /*MDFCN_DT*/
	, 'N'                                                                                     /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'FRM';


--[모집공고]가산금(장애,장기치료,제3국출생양육)
DELETE FROM TB_SMBSN_DOC_TYPE WHERE PBANCRC_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG_RND WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 10000 AND 19999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('10001','10002','11001','N','가산금이관데이터(장애)'			,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N'),
('10002','10002','11002','N','가산금이관데이터(장기치료)'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N'),
('10003','10002','11003','N','가산금이관데이터(제3국출생양육)'	,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N');

--[지원]가산금
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG_RND WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 10000 AND 19999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+10000)                                                                                                         /*SPRT_SN*/
	, (CASE WHEN P = '장애' THEN '10001' WHEN P = '장기치료' THEN '10002' WHEN P = '제3국' THEN '10003' ELSE '' END)       /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = D), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(E, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(K, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(L, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = R), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN O IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(O, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN O IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(O, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'ADT';

--가산금지원
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG_RND WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT WHERE SPRT_SN BETWEEN 10000 AND 19999;
INSERT INTO TB_ADTN_AMT_SPRT (
	SPRT_SN				,
	ADTN_AMT_GIVE_RSN		,
	SGNT_FILE_SN		,
	SGNTR_FLNM
)
SELECT
	(B+10000)									/*SPRT_SN*/
	, NVL(Q, '-')								/*ADTN_AMT_GIVE_RSN*/
	, '484'										/*SGNT_FILE_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')		/*SGNTR_FLNM*/
FROM TB_MIGRATION
WHERE A = 'ADT';

--가산금지원현황
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG_RND WHERE SPRT_SN BETWEEN 10000 AND 19999;
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 10000 AND 19999;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG (
	ADTN_AMT_SPRT_PRCN_MNG_SN		,
	SPRT_SN		,
	DSBLTY_DEGR		,
	DSBLTY_SE		,
	DSBLTY_RMRK		,
	DSS_NM		,
	HSPTZ_PERIOD		,
	HSPTZ_INFO		,
	LPERIOD_CURE_RMRK		,
	FRST_CHDR_FLNM		,
	FRST_CHDR_BRDT_YMD		,
	FRST_CHDR_BRTH_NTN_NM		,
	SCNDRY_CHDR_FLNM		,
	SCNDRY_CHDR_BRDT_YMD		,
	SCNDRY_CHDR_BRTH_NTN_NM		,
	CHDR_NTRE_RMRK		,
	GIVE_DCSN_YMD		,
	FRST_DCSN_AMT		,
	GIVE_BGNG_YM		,
	GIVE_END_YM		,
	TOT_GIVE_NMTM		,
	BACNT_BANK_CD		,
	ACTNO		,
	DPSTR		,
	GIVE_TRMN_YMD		,
	TRMN_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG.NEXTVAL                                                             /*ADTN_AMT_SPRT_PRCN_MNG_SN*/
	, (B+10000)                                                                                        /*SPRT_SN*/
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_C)                                 /*DSBLTY_DEGR*/
	, A_D                                                                                             /*DSBLTY_SE*/
	, A_E                                                                                             /*DSBLTY_RMRK*/
	, A_F                                                                                             /*DSS_NM*/
	, A_G                                                                                             /*HSPTZ_PERIOD*/
	, A_H                                                                                             /*HSPTZ_INFO*/
	, A_I                                                                                             /*LPERIOD_CURE_RMRK*/
	, A_J                                                                                             /*FRST_CHDR_FLNM*/
	, REPLACE(REPLACE(A_K,'-',''),'.','')                                                             /*FRST_CHDR_BRDT_YMD*/
	, A_L                                                                                             /*FRST_CHDR_BRTH_NTN_NM*/
	, A_M                                                                                             /*SCNDRY_CHDR_FLNM*/
	, REPLACE(REPLACE(A_N,'-',''),'.','')                                                             /*SCNDRY_CHDR_BRDT_YMD*/
	, A_O                                                                                             /*SCNDRY_CHDR_BRTH_NTN_NM*/
	, A_P                                                                                             /*CHDR_NTRE_RMRK*/
	, REPLACE(REPLACE(R,'-',''),'.','')                                                               /*GIVE_DCSN_YMD*/
	, S                                                                                               /*FRST_DCSN_AMT*/
	, REPLACE(REPLACE(U,'-',''),'.','')                                                               /*GIVE_BGNG_YM*/
	, REPLACE(REPLACE(V,'-',''),'.','')                                                               /*GIVE_END_YM*/
	, W                                                                                               /*TOT_GIVE_NMTM*/
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = SUBSTR(X, 0, INSTR(X, ' ')-1))       /*BACNT_BANK_CD*/
	, FN_CRYPTO_ENC(SUBSTR(X, INSTR(X, ' ')+1),'M_KEY')                                           /*ACTNO*/
	, Y                                                                                               /*DPSTR*/
	, REPLACE(REPLACE(Z,'-',''),'.','')                                                               /*GIVE_TRMN_YMD*/
	, A_B                                                                                             /*TRMN_RSN*/
	, 'MBR_0000000064'                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                /*MDFR_ID*/
	, SYSDATE                                                                                         /*REG_DT*/
	, SYSDATE                                                                                         /*MDFCN_DT*/
	, 'N'                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'ADT_PRC';

--가산금지원현황관리회차(1~16회차)
DELETE FROM TB_ADTN_AMT_SPRT_PRCN_MNG_RND WHERE SPRT_SN BETWEEN 10000 AND 19999;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_Q,1 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_Q IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_R,2 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_R IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_S,3 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_S IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_T,4 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_T IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_U,5 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_U IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_V,6 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_V IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_W,7 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_W IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_X,8 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_X IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_Y,9 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_Y IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),A_Z,10 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND A_Z IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_A,11 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_A IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_B,12 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_B IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_C,13 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_C IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_D,14 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_D IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_E,15 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_E IS NOT NULL;
INSERT INTO TB_ADTN_AMT_SPRT_PRCN_MNG_RND (ADTN_AMT_SPRT_PRCN_MNG_RND_SN,SPRT_SN,GIVE_YM,GIVE_AMT,RND) SELECT SEQ_TB_ADTN_AMT_SPRT_PRCN_MNG_RND.NEXTVAL,(B+10000),REPLACE(REPLACE(' ','-',''),'.',''),B_F,16 FROM TB_MIGRATION WHERE A = 'ADT_PRC' AND B_F IS NOT NULL;


--[모집공고]장학금
DELETE FROM TB_SHOL_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 20000 AND 29999;
DELETE FROM TB_SHOL_SPRT WHERE SPRT_SN BETWEEN 20000 AND 29999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 20000 AND 29999;
DELETE from TB_SMBSN_DOC WHERE SMBSN_DOC_TYPE_SN IN (SELECT SMBSN_DOC_TYPE_SN FROM  TB_SMBSN_DOC_TYPE WHERE PBANCRC_SN BETWEEN 20000 AND 29999  );
DELETE FROM TB_SMBSN_DOC_TYPE  WHERE PBANCRC_SN BETWEEN 20000 AND 29999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 20000 AND 29999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('20001','10003','10003','N','장학금이관데이터','-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N');

--문서유형
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','ntkrdf1','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','ntkrdf2','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','ntkrdf3','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','ntkrdf4','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','ntkrdf5','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','thirdcnty1','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','thirdcnty2','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','thirdcnty3','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','thirdcnty4','N');
INSERT INTO TB_SMBSN_DOC_TYPE (SMBSN_DOC_TYPE_SN,PBANCRC_SN,SMBSN_DOC_TYPE_VL,DEL_YN) VALUES (SEQ_TB_SMBSN_DOC_TYPE.NEXTVAL,'20001','thirdcnty5','N');

--[지원]장학금
DELETE FROM TB_SHOL_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 20000 AND 29999;
DELETE FROM TB_SHOL_SPRT WHERE SPRT_SN BETWEEN 20000 AND 29999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 20000 AND 29999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+20000)                                                                                                          /*SPRT_SN*/
	, '20001'                                                                                                          /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(F, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = G), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(H, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(N, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(O, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'SHO';

--장학금지원
DELETE FROM TB_SHOL_SPRT WHERE SPRT_SN BETWEEN 20000 AND 29999;
INSERT INTO TB_SHOL_SPRT (
	SPRT_SN		,
	NTKRDF_OPTR_CD		,
	NTKRDF_HANAWON_TH		,
	NTKRDF_OPTR_ENTRY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	SHOL_SLCTN_TYPE		,
	SGNT_FILE_SN		,
	SGNTR_FLNM
)
SELECT
	(B+20000)
	, NULL
	, NULL
	, NULL
	, NULL
	, (CASE WHEN I IS NOT NULL THEN 'ntkrdf' ELSE 'thirdcnty' END)||(CASE WHEN E = '대학원생' THEN '1' WHEN E = '일반대(연속지원)' THEN '2_1' WHEN E = '일반대(1회지원)' THEN '2_2' WHEN E = '전문대' THEN '2_3' WHEN E = '사이버/방송/통신대' THEN '2_4' WHEN E = '일반대' THEN '3' WHEN E = '중학생' THEN '4_1' WHEN E = '고등학생' THEN '4_2' WHEN E = '검정고시' THEN '5' ELSE '' END)
	, '484'
	, FN_CRYPTO_ENC(F,'M_KEY')
FROM TB_MIGRATION
WHERE A = 'SHO';

--장학금지원현황
DELETE FROM TB_SHOL_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 20000 AND 29999;
INSERT INTO TB_SHOL_SPRT_PRCN_MNG (
	SHOL_SPRT_PRCN_MNG_SN		,
	SPRT_SN		,
	SLCTN_MTHD_CD		,
	SLCTN_MMT_CD		,
	FNCRSC_CD		,
	GIVE_YMD		,
	SHOL_GIVE_AMT		,
	RMRK		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_SHOL_SPRT_PRCN_MNG.NEXTVAL
	, (B+20000)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = Q)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = R)
	, REPLACE(REPLACE(S,'-',''),'.','')
	, T
	, U
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'SHO_PRC';


--[모집공고]화상영어
DELETE FROM TB_VDOENG_EDU_PRCN_MNG WHERE SPRT_SN BETWEEN 30000 AND 39999;
DELETE FROM TB_VDOENG_EDU WHERE SPRT_SN BETWEEN 30000 AND 39999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 30000 AND 39999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 30000 AND 39999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('30001','10005','10005','N','화상영어이관데이터','-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N');

--[지원]화상영어
DELETE FROM TB_VDOENG_EDU_PRCN_MNG WHERE SPRT_SN BETWEEN 30000 AND 39999;
DELETE FROM TB_VDOENG_EDU WHERE SPRT_SN BETWEEN 30000 AND 39999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 30000 AND 39999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+30000)                                                                                                          /*SPRT_SN*/
	, '30001'                                                                                                          /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = I), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(J, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(L, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(M, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = T), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'VDO';

--화상영어지원
DELETE FROM TB_VDOENG_EDU WHERE SPRT_SN BETWEEN 30000 AND 39999;
INSERT INTO TB_VDOENG_EDU (
	SPRT_SN		,
	APLCNT_TYPE		,
	BRPLC_CD		,
	EXIST_BNF_CD		,
	RCOBL_YN		,
	RCOBL_SGNT_FILE_SN		,
	APLCNT_OGDP		,
	NTKRDF_SE		,
	NTKRDF_FLNM		,
	NTKRDF_HANAWON_TH		,
	NTKRDF_ENTCNY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	EDU_SPRT_TRPR_REL_CD		,
	EDU_SPRT_TRPR_REL_DTL		,
	PRTCR_FLNM		,
	PRTCR_GENDER_CD		,
	PRTCR_BRDT_YMD		,
	PRTCR_MBPHNO		,
	PRTCR_ZIP		,
	PRTCR_ADDR		,
	PRTCR_DADDR		,
	SGNT_FILE_SN		,
	SGNTR_FLNM		,
	PRTCR_SGNT_FILE_SN		,
	PRTCR_SGNTR_FLNM
)
SELECT
	(B+30000)
	, 'NTK_PRT'
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = K), '-')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = (CASE WHEN O = 'O' THEN '신규' WHEN P = 'O' THEN '전년도 수혜' WHEN Q = 'O' THEN '전전연도 수혜' ELSE '' END)), '-')
	, (CASE WHEN R = 'O' THEN 'Y' ELSE 'N' END)
	, NULL
	, NVL(S, '-')
	, E
	, FN_CRYPTO_ENC(D,'M_KEY')
	, G
	, NULL
	, NULL
	, NULL
	, NULL
	, FN_CRYPTO_ENC(D,'M_KEY')
	, (CASE WHEN D = '부' THEN '1001' WHEN D = '모' THEN '1002' ELSE '' END)
	, NULL
	, FN_CRYPTO_ENC(F,'M_KEY')
	, NULL
	, NULL
	, NULL
	, '484'
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')
	, '484'
	, FN_CRYPTO_ENC(D,'M_KEY')
FROM TB_MIGRATION
WHERE A = 'VDO';

--화상영어지원현황
DELETE FROM TB_VDOENG_EDU_PRCN_MNG WHERE SPRT_SN BETWEEN 30000 AND 39999;
INSERT INTO TB_VDOENG_EDU_PRCN_MNG (
	VDOENG_EDU_PRCN_MNG_SN		,
	SPRT_SN		,
	LNBK_DPCN_TRGT_YN		,
	MDW_GBKHM_YMD		,
	GBKHM_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_VDOENG_EDU_PRCN_MNG.NEXTVAL
	, (B+30000)
	, (CASE WHEN O = 'O' THEN 'Y' WHEN O = 'X' THEN 'N' ELSE '' END)
	, REPLACE(REPLACE(U,'-',''),'.','')
	, V
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'VDO_PRC';


--[모집공고]학습지
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_LNBK_SPRT WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('40001','10006','10006','N','학습지이관데이터','-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064'/*RGTR_ID*/,'MBR_0000000064'/*MDFR_ID*/,SYSDATE/*REG_DT*/,SYSDATE/*MDFCN_DT*/,'N');

--[지원]학습지
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_LNBK_SPRT WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+40000)                                                                                                          /*SPRT_SN*/
	, '40001'                                                                                                          /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(D, '-'),'M_KEY')                                                                              /*FLNM*/
	, '-'                                                                                                             /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(E, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(I, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_R), '-')                                       /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'LNB';

--학습지지원
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
DELETE FROM TB_LNBK_SPRT WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_LNBK_SPRT (
	SPRT_SN		,
	APLCNT_TYPE		,
	EDU_SPRT_TRPR_REL_CD		,
	EDU_SPRT_TRPR_REL_DTL		,
	HSHLDR_FLNM		,
	RCOBL_YN		,
	RCOBL_SGNT_FILE_SN		,
	SGNT_FILE_SN		,
	SGNTR_FLNM		,
	PRTCR_SGNT_FILE_SN		,
	PRTCR_SGNTR_FLNM
)
SELECT
	(B+40000)
	, (CASE WHEN H IS NOT NULL THEN 'NTK' ELSE 'NOR' END)
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = F AND GROUP_CD = '100007'), '-')
	, NULL
	, FN_CRYPTO_ENC(NVL(J, '-'),'M_KEY')
	, (CASE WHEN K = 'O' THEN 'Y' WHEN K = 'X' THEN 'N' ELSE '-' END)
	, NULL
	, '484'
	, FN_CRYPTO_ENC(D,'M_KEY')
	, '484'
	, FN_CRYPTO_ENC(D,'M_KEY')
FROM TB_MIGRATION
WHERE A = 'LNB';

--학습지지원정보(1순위)
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_LNBK_SPRT_BSC_INFO (
	LNBK_SPRT_BSC_INFO_SN		,
	SPRT_SN		,
	RNKG		,
	FLNM		,
	BRDT_YMD		,
	BRPLC_CD		,
	HANAWON_TH		,
	ENTCNY_YR		,
	NTKRDF_OPRT_SE		,
	NTKRDF_OPRT_FLNM		,
	NTKRDF_OPRT_HANAWON_TH		,
	NTKRDF_OPRT_ENCTNY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	EXIST_BNF_CD		,
	SPRT_TRGT_YN		,
	VDOENG_DPCN_TRGT_YN		,
	MDW_GBKHM_YMD		,
	GBKHM_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_LNBK_SPRT_BSC_INFO.NEXTVAL
	, (B+40000)
	, 1
	, FN_CRYPTO_ENC(N,'M_KEY')
	, FN_CRYPTO_ENC(O,'M_KEY')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P), '-')
	, Q
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = (CASE WHEN R = 'O' THEN '신규' WHEN S = 'O' THEN '전년도 수혜' WHEN T = 'O' THEN '전전연도 수혜' ELSE '' END)), '-')
	, (CASE WHEN M = 'O' THEN 'Y' WHEN M = 'X' THEN 'N' ELSE '' END)
	, (CASE WHEN U = 'O' THEN 'Y' WHEN U = 'X' THEN 'N' ELSE '' END)
	, REPLACE(REPLACE(V,'-',''),'.','')
	, W
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'LNB_PRC' AND N IS NOT NULL;

--학습지지원정보(2순위)
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_LNBK_SPRT_BSC_INFO (
	LNBK_SPRT_BSC_INFO_SN		,
	SPRT_SN		,
	RNKG		,
	FLNM		,
	BRDT_YMD		,
	BRPLC_CD		,
	HANAWON_TH		,
	ENTCNY_YR		,
	NTKRDF_OPRT_SE		,
	NTKRDF_OPRT_FLNM		,
	NTKRDF_OPRT_HANAWON_TH		,
	NTKRDF_OPRT_ENCTNY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	EXIST_BNF_CD		,
	SPRT_TRGT_YN		,
	VDOENG_DPCN_TRGT_YN		,
	MDW_GBKHM_YMD		,
	GBKHM_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_LNBK_SPRT_BSC_INFO.NEXTVAL
	, (B+40000)
	, 2
	, FN_CRYPTO_ENC(Z,'M_KEY')
	, FN_CRYPTO_ENC(A_A,'M_KEY')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_B), '-')
	, A_C
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = (CASE WHEN A_D = 'O' THEN '신규' WHEN A_E = 'O' THEN '전년도 수혜' WHEN A_F = 'O' THEN '전전연도 수혜' ELSE '' END)), '-')
	, (CASE WHEN A_Y = 'O' THEN 'Y' WHEN A_Y = 'X' THEN 'N' ELSE '' END)
	, (CASE WHEN A_G = 'O' THEN 'Y' WHEN A_G = 'X' THEN 'N' ELSE '' END)
	, REPLACE(REPLACE(A_H,'-',''),'.','')
	, A_I
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'LNB_PRC' AND Z IS NOT NULL;

--학습지지원정보(3순위)
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_LNBK_SPRT_BSC_INFO (
	LNBK_SPRT_BSC_INFO_SN		,
	SPRT_SN		,
	RNKG		,
	FLNM		,
	BRDT_YMD		,
	BRPLC_CD		,
	HANAWON_TH		,
	ENTCNY_YR		,
	NTKRDF_OPRT_SE		,
	NTKRDF_OPRT_FLNM		,
	NTKRDF_OPRT_HANAWON_TH		,
	NTKRDF_OPRT_ENCTNY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	EXIST_BNF_CD		,
	SPRT_TRGT_YN		,
	VDOENG_DPCN_TRGT_YN		,
	MDW_GBKHM_YMD		,
	GBKHM_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_LNBK_SPRT_BSC_INFO.NEXTVAL
	, (B+40000)
	, 3
	, FN_CRYPTO_ENC(A_L,'M_KEY')
	, FN_CRYPTO_ENC(A_M,'M_KEY')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_N), '-')
	, A_O
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = (CASE WHEN A_P = 'O' THEN '신규' WHEN A_Q = 'O' THEN '전년도 수혜' WHEN A_R = 'O' THEN '전전연도 수혜' ELSE '' END)), '-')
	, (CASE WHEN A_K = 'O' THEN 'Y' WHEN A_K = 'X' THEN 'N' ELSE '' END)
	, (CASE WHEN A_S = 'O' THEN 'Y' WHEN A_S = 'X' THEN 'N' ELSE '' END)
	, REPLACE(REPLACE(A_T,'-',''),'.','')
	, A_U
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'LNB_PRC' AND A_L IS NOT NULL;

--학습지지원정보(4순위)
DELETE FROM TB_LNBK_SPRT_BSC_INFO WHERE SPRT_SN BETWEEN 40000 AND 49999;
INSERT INTO TB_LNBK_SPRT_BSC_INFO (
	LNBK_SPRT_BSC_INFO_SN		,
	SPRT_SN		,
	RNKG		,
	FLNM		,
	BRDT_YMD		,
	BRPLC_CD		,
	HANAWON_TH		,
	ENTCNY_YR		,
	NTKRDF_OPRT_SE		,
	NTKRDF_OPRT_FLNM		,
	NTKRDF_OPRT_HANAWON_TH		,
	NTKRDF_OPRT_ENCTNY_YR		,
	NTKRDF_ACRTFCT_FILE_SN		,
	EXIST_BNF_CD		,
	SPRT_TRGT_YN		,
	VDOENG_DPCN_TRGT_YN		,
	MDW_GBKHM_YMD		,
	GBKHM_RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_LNBK_SPRT_BSC_INFO.NEXTVAL
	, (B+40000)
	, 4
	, FN_CRYPTO_ENC(A_X,'M_KEY')
	, FN_CRYPTO_ENC(A_Y,'M_KEY')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_Z), '-')
	, B_A
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NULL
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = (CASE WHEN B_B = 'O' THEN '신규' WHEN B_C = 'O' THEN '전년도 수혜' WHEN B_D = 'O' THEN '전전연도 수혜' ELSE '' END)), '-')
	, (CASE WHEN B_W = 'O' THEN 'Y' WHEN B_W = 'X' THEN 'N' ELSE '' END)
	, (CASE WHEN B_E = 'O' THEN 'Y' WHEN B_E = 'X' THEN 'N' ELSE '' END)
	, REPLACE(REPLACE(B_F,'-',''),'.','')
	, B_G
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*REG_DT*/
	, CASE WHEN C IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(C, 'YYYY-MM-DD') END                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'LNB_PRC' AND A_X IS NOT NULL;

--[모집공고]정착지원
DELETE FROM TB_SPFST_PRCN_MNG WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_SPFST WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 50000 AND 59999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('50001','10007','11004','N','정착지원(초급)이관데이터'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('50002','10007','11005','N','정착지원(중급)이관데이터'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('50003','10007','11006','N','정착지원(고급)이관데이터'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('50004','10007','11007','N','정착지원(이론)이관데이터'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('50005','10007','11008','N','정착지원(실기)이관데이터'		,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('50006','10007','11009','N','정착지원(자격시험)이관데이터'	,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N');

--[지원]정착지원
DELETE FROM TB_SPFST_PRCN_MNG WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_SPFST WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 50000 AND 59999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+50000)                                                                                                          /*SPRT_SN*/
	, (CASE WHEN C = '초급' THEN '50001' WHEN C = '중급' THEN '50002' WHEN C = '고급' THEN '50003' WHEN C = '이론' THEN '50004' WHEN C = '실기' THEN '50005' WHEN C = '자격시험' THEN '50006' ELSE '' END)
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = F), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(G, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(I, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = V), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN D IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(SUBSTR(D, 0, 10), 'YYYY-MM-DD') END   /*REG_DT*/
	, CASE WHEN D IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(SUBSTR(D, 0, 10), 'YYYY-MM-DD') END   /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'SPF';

--정착지원
DELETE FROM TB_SPFST_PRCN_MNG WHERE SPRT_SN BETWEEN 50000 AND 59999;
DELETE FROM TB_SPFST WHERE SPRT_SN BETWEEN 50000 AND 59999;
INSERT INTO TB_SPFST (
	SPRT_SN		,
	PHOTO_FILE_SN		,
	ORDP_NM		,
	CRTFCT_RCV_ZIP	 	,
	CRTFCT_RCV_ADDR		,
	CRTFCT_RCV_DADDR		,
	EML		,
	LAST_ACBG_CD		,
	LAST_ACBG_ETC		,
	OCPT_INST_TYPE_CD		,
	OCPT_INST_TYPE_ETC		,
	PTEXP		,
	APLY_MTV		,
	EDU_FNSH_YMD		,
	SGNT_FILE_SN		,
	SGNTR_FLNM
)
SELECT
	(B+50000)                                                                         /*SPRT_SN*/
	, '0'                                                                            /*PHOTO_FILE_SN*/
	, NVL(O, '-')                                                                    /*ORDP_NM*/
	, NULL                                                                           /*CRTFCT_RCV_ZIP*/
	, NULL                                                                           /*CRTFCT_RCV_ADDR*/
	, NULL                                                                           /*CRTFCT_RCV_DADDR*/
	, FN_CRYPTO_ENC(NVL(P, '-'),'M_KEY')                                             /*EML*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = Q), '-')        /*LAST_ACBG_CD*/
	, NULL                                                                           /*LAST_ACBG_ETC*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = R), '-')        /*OCPT_INST_TYPE_CD*/
	, NULL                                                                           /*OCPT_INST_TYPE_ETC*/
	, S                                                                              /*PTEXP*/
	, T                                                                              /*APLY_MTV*/
	, REPLACE(U, '-', '')                                                            /*EDU_FNSH_YMD*/
	, '484'                                                                          /*SGNT_FILE_SN*/
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                             /*SGNTR_FLNM*/
FROM TB_MIGRATION
WHERE A = 'SPF';

--정착지원현황
DELETE FROM TB_SPFST_PRCN_MNG WHERE SPRT_SN BETWEEN 50000 AND 59999;
INSERT INTO TB_SPFST_PRCN_MNG (
	SPFST_PRCN_MNG_SN		,
	SPRT_SN		,
	SPFST_QLFC_TEST_INFO_SN		,
	EXSLNO		,
	TEST_RSLT_CD		,
	PASS_YMD		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_SPFST_PRCN_MNG.NEXTVAL
	, (B+50000)
	, NULL
	, V
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_A), '-')
	, REPLACE(REPLACE(A_B,'-',''),'.','')
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE   /*REG_DT*/
	, SYSDATE   /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'SPF_PRC';


--[모집공고]바우처카드
DELETE FROM TB_EMVUCD_USE_INFO WHERE REG_DT = TO_DATE('19800101', 'YYYYMMDD');
DELETE FROM TB_EMVUCD_SPRT_PRCN_MNG_TKCLS WHERE SPRT_SN BETWEEN 60000 AND 69999;
DELETE FROM TB_EMVUCD_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 60000 AND 69999;
DELETE FROM TB_EMVUCD WHERE SPRT_SN BETWEEN 60000 AND 69999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 60000 AND 69999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 60000 AND 69999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('60001','10008','10008','N','바우처카드이관데이터','-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N');

--[지원]바우처카드
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 60000 AND 69999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+60000)                                                                                                          /*SPRT_SN*/
	, '60001'                                                                                                          /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = D), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(E, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(F, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = S), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE                                                                                                         /*REG_DT*/
	, SYSDATE                                                                                                         /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EMV';

--취업바우처카드
DELETE FROM TB_EMVUCD WHERE SPRT_SN BETWEEN 60000 AND 69999;
INSERT INTO TB_EMVUCD (
	SPRT_SN		,
	HANACT_CD		,
	HNW_TH		,
	HANAWON_FNSH_YR		,
	DSCSN_YMD		,
	CNSL_FLNM		,
	EML
)
SELECT
	(B+60000)                                                                        /*SPRT_SN*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P), '-')       /*HANACT_CD*/
	, NVL(N, '-')                                                                   /*HNW_TH*/
	, NVL(M, '-')                                                                   /*HANAWON_FNSH_YR*/
	, REPLACE(NVL(O, '19800101'), '-', '')		                                    /*DSCSN_YMD*/
	, FN_CRYPTO_ENC(NVL(Q, '-'),'M_KEY')		                                /*CNSL_FLNM*/
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')                                        /*EML*/
FROM TB_MIGRATION
WHERE A = 'EMV';

--취업바우처카드지원현황
DELETE FROM TB_EMVUCD_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 60000 AND 69999;
INSERT INTO TB_EMVUCD_SPRT_PRCN_MNG (
	EMVUCD_SPRT_PRCN_MNG_SN		,
	SPRT_SN		,
	SCHL_NM		,
	MJR_NM		,
	SCHLYR		,
	OGDP		,
	APLCNT_QLFC_CD		,
	EXIST_CD_USE_YN		,
	FRST_CARD_NO		,
	SCNDRY_CARD_NO		,
	THIRD_CARD_NO		,
	BFRHD_APRV_YMD		,
	APLY_AMT		,
	PNTY_YN		,
	RMRK		,
	HANACT_MEMO		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_EMVUCD_SPRT_PRCN_MNG.NEXTVAL
	, (B+60000)
	, I
	, J
	, K
	, L
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = S)
	, (CASE WHEN T = 'O' THEN 'Y' WHEN T = 'X' THEN 'N' ELSE '' END)
	, FN_CRYPTO_ENC(U,'M_KEY')
	, FN_CRYPTO_ENC(V,'M_KEY')
	, FN_CRYPTO_ENC(W,'M_KEY')
	, REPLACE(REPLACE(X,'-',''),'.','')
	, Y
	, (CASE WHEN A_C = 'O' THEN 'Y' WHEN A_C = 'X' THEN 'N' ELSE '' END)
	, A_D
	, NULL
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE                                                                                                         /*REG_DT*/
	, SYSDATE                                                                                                         /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EMV_PRC';

--취업바우처카드지원현황 수강정보(1~3)
DELETE FROM TB_EMVUCD_SPRT_PRCN_MNG_TKCLS WHERE SPRT_SN BETWEEN 60000 AND 69999;
INSERT INTO TB_EMVUCD_SPRT_PRCN_MNG_TKCLS (EMVUCD_SPRT_PRCN_MNG_TKCLS_SN,SPRT_SN,SBJCT_CD,SBJCT_NM,EDNST_CD,EDNST_NM,TKCLS_PERIOD) SELECT SEQ_TB_EMVUCD_SPRT_PRCN_MNG_TKCLS.NEXTVAL, (B+60000), (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_E), A_F, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_G), A_H, A_I FROM TB_MIGRATION WHERE A = 'EMV_PRC' AND (A_E IS NOT NULL AND A_F IS NOT NULL);
INSERT INTO TB_EMVUCD_SPRT_PRCN_MNG_TKCLS (EMVUCD_SPRT_PRCN_MNG_TKCLS_SN,SPRT_SN,SBJCT_CD,SBJCT_NM,EDNST_CD,EDNST_NM,TKCLS_PERIOD) SELECT SEQ_TB_EMVUCD_SPRT_PRCN_MNG_TKCLS.NEXTVAL, (B+60000), (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_J), A_K, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_L), A_M, A_N FROM TB_MIGRATION WHERE A = 'EMV_PRC' AND (A_J IS NOT NULL AND A_K IS NOT NULL);
INSERT INTO TB_EMVUCD_SPRT_PRCN_MNG_TKCLS (EMVUCD_SPRT_PRCN_MNG_TKCLS_SN,SPRT_SN,SBJCT_CD,SBJCT_NM,EDNST_CD,EDNST_NM,TKCLS_PERIOD) SELECT SEQ_TB_EMVUCD_SPRT_PRCN_MNG_TKCLS.NEXTVAL, (B+60000), (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_O), A_P, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_Q), A_R, A_S FROM TB_MIGRATION WHERE A = 'EMV_PRC' AND (A_O IS NOT NULL AND A_P IS NOT NULL);

--취업바우처카드사용내역
DELETE FROM TB_EMVUCD_USE_INFO WHERE REG_DT = TO_DATE('19800101', 'YYYYMMDD');
INSERT INTO TB_EMVUCD_USE_INFO (
	EMVUCD_USE_INFO_SN		,
	CARD_NO		,
	ISSUIST_FLNM		,
	APRV_YMD		,
	APRV_NO		,
	FRCS_NM		,
	APRV_AMT		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_EMVUCD_USE_INFO.NEXTVAL                                                                                    /*EMVUCD_USE_INFO_SN*/
	, FN_CRYPTO_ENC(NVL(B, '-'),'M_KEY')                                                                              /*CARD_NO*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                                              /*ISSUIST_FLNM*/
	, REPLACE(REPLACE(NVL(D, '19800101'),'-',''),'.','')                                                              /*APRV_YMD*/
	, NVL(E, '-')                                                                                                     /*APRV_NO*/
	, NVL(F, '-')                                                                                                     /*FRCS_NM*/
	, NVL(G, '0')                                                                                                     /*APRV_AMT*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, TO_DATE('19800101', 'YYYYMMDD')                                                                                 /*REG_DT*/
	, TO_DATE('19800101', 'YYYYMMDD')                                                                                 /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EMV_CARD';

--[모집공고]취업연계직업훈련
DELETE FROM TB_EMPCNN_VOCTRN_PRCN_MNG WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_EMPCNN_VOCTRN WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 70000 AND 79999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('70001','10009','11010','N','취업연계직업훈련(버스운전기사)이관데이터'			,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('70002','10009','11011','N','취업연계직업훈련(회계실무자)이관데이터'			,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('70003','10009','11012','N','취업연계직업훈련(전기기능사)이관데이터'			,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('70004','10009','11013','N','취업연계직업훈련(SW테스터)이관데이터'			,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N'),
('70005','10009','11015','N','취업연계직업훈련(삼성중공업 직업기술생)이관데이터'	,'-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N');


--[지원]취업연계직업훈련
DELETE FROM TB_EMPCNN_VOCTRN_PRCN_MNG WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_EMPCNN_VOCTRN WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 70000 AND 79999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+70000)                                                                                                          /*SPRT_SN*/
	, (CASE WHEN SUBSTR(C, 0, 2) = '버스' THEN '70001' WHEN SUBSTR(C, 0, 2) = '회계' THEN '70002' WHEN SUBSTR(C, 0, 2) = '전기' THEN '70003' WHEN SUBSTR(C, 0, 2) = 'SW' THEN '70004' WHEN SUBSTR(C, 0, 2) = '삼성' THEN '70005' ELSE '' END)
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = F), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(G, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(M, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(N, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = X), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, CASE WHEN D IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(SUBSTR(D, 0, 10), 'YYYY-MM-DD') END   /*REG_DT*/
	, CASE WHEN D IS NULL THEN TO_DATE('1980-01-01', 'YYYY-MM-DD') ELSE TO_DATE(SUBSTR(D, 0, 10), 'YYYY-MM-DD') END   /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EMP';


--[지원]취업연계직업훈련
DELETE FROM TB_EMPCNN_VOCTRN_PRCN_MNG WHERE SPRT_SN BETWEEN 70000 AND 79999;
DELETE FROM TB_EMPCNN_VOCTRN WHERE SPRT_SN BETWEEN 70000 AND 79999;
INSERT INTO TB_EMPCNN_VOCTRN (
	SPRT_SN		,
	LAST_ACBG_SCHL_NM		,
	LAST_ACBG_SCHL_GRDTN_CD		,
	LAST_ACBG_MJR_NM		,
	EMPM_STTS_YN		,
	EMPM_WRC_NM		,
	HGVLC_YN		,
	BUS_DRVNG_CRTFCT_YN		,
	HOPE_TRPTT_BZENTY		,
	RSNAPLC		,
	SGNT_FILE_SN		,
	SGNTR_FLNM
)
SELECT
	(B+70000)                                                                        /*SPRT_SN*/
	, NVL(O, '-')                                                                   /*LAST_ACBG_SCHL_NM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = P), '-')       /*LAST_ACBG_SCHL_GRDTN_CD*/
	, NVL(Q, '-')                                                                   /*LAST_ACBG_MJR_NM*/
	, (CASE WHEN R = 'O' THEN 'Y' WHEN R = 'X' THEN 'N' ELSE '-' END)               /*EMPM_STTS_YN*/
	, NVL(S, '-')                                                                   /*EMPM_WRC_NM*/
	, (CASE WHEN U = 'O' THEN 'Y' WHEN U = 'X' THEN 'N' ELSE '' END)                /*HGVLC_YN*/
	, (CASE WHEN V = 'O' THEN 'Y' WHEN V = 'X' THEN 'N' ELSE '' END)                /*BUS_DRVNG_CRTFCT_YN*/
	, W                                                                             /*HOPE_TRPTT_BZENTY*/
	, NVL(T, '-')                                                                   /*RSNAPLC*/
	, '484'                                                                         /*SGNT_FILE_SN*/
	, FN_CRYPTO_ENC(NVL(E, '-'),'M_KEY')                                            /*SGNTR_FLNM*/
FROM TB_MIGRATION
WHERE A = 'EMP';

--[지원]취업연계직업훈련현황관리
DELETE FROM TB_EMPCNN_VOCTRN_PRCN_MNG WHERE SPRT_SN BETWEEN 70000 AND 79999;
INSERT INTO TB_EMPCNN_VOCTRN_PRCN_MNG (
	EMPCNN_VOCTRN_PCRN_MNG_SN		,
	SPRT_SN		,
	EDU_BGNG_YMD		,
	EDU_END_YMD		,
	EDU_FNSH_CMPTN_YN		,
	MDW_GVUP_YN		,
	CRTFCT_ACQS_YN		,
	CRTFCT_INFO		,
	EMPM_YN		,
	EMPM_CO_NM		,
	RMRK		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_EMPCNN_VOCTRN_PRCN_MNG.NEXTVAL
	, (B+70000)
	, REPLACE(REPLACE(TRIM(SUBSTR(X, 0, INSTR(X, '~')-1)),'-',''),'.','')
	, REPLACE(REPLACE(TRIM(SUBSTR(X, INSTR(X, '~')+1)),'-',''),'.','')
	, (CASE WHEN Y = 'O' THEN 'Y' WHEN Y = 'X' THEN 'N' ELSE '-' END)
	, (CASE WHEN Z = 'O' THEN 'Y' WHEN Z = 'X' THEN 'N' ELSE '-' END)
	, (CASE WHEN A_A = 'O' THEN 'Y' WHEN A_A = 'X' THEN 'N' ELSE '-' END)
	, A_B
	, (CASE WHEN A_C = 'O' THEN 'Y' WHEN A_C = 'X' THEN 'N' ELSE '-' END)
	, A_D
	, A_E
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE                  /*REG_DT*/
	, SYSDATE                  /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EMP_PRC';


--[모집공고]긴급생계비
DELETE FROM TB_EMLVEX_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_EMLVEX_SPRT WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_PBANCRC WHERE PBANCRC_SN BETWEEN 80000 AND 89999;
INSERT INTO TB_PBANCRC(PBANCRC_SN,PBANCRC_CTGRY_FRST_CD,BIZ_SE_CD,RLS_YN,PBANCRC_NM,PBANCRC_CN,INQ_CNT,PBANCRC_BGNG_DT,PBANCRC_END_DT,RGTR_ID,MDFR_ID,REG_DT,MDFCN_DT,DEL_YN)VALUES
('80001','10001','10001','N','긴급생계비이관데이터','-',0,TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'MBR_0000000064','MBR_0000000064',TO_DATE('19800101','YYYYMMDD'),TO_DATE('19800101','YYYYMMDD'),'N');


--[지원]긴급생계비
DELETE FROM TB_EMLVEX_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_EMLVEX_SPRT WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_SPRT WHERE SPRT_SN BETWEEN 80000 AND 89999;
INSERT INTO TB_SPRT (
	SPRT_SN		,
	PBANCRC_SN		,
	FLNM		,
	GENDER_CD		,
	BRDT_YMD		,
	MBPHNO		,
	ZIP		,
	ADDR		,
	DADDR		,
	TMPR_STRG_DATA		,
	SPRT_STTS_CD		,
	RSN		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	(B+80000)                                                                                                          /*SPRT_SN*/
	, '80001'                                                                                                          /*PBANCRC_SN*/
	, FN_CRYPTO_ENC(NVL(C, '-'),'M_KEY')                                                                              /*FLNM*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = D), '-')                                         /*GENDER_CD*/
	, FN_CRYPTO_ENC(NVL(E, '19800101'),'M_KEY')                                                                       /*BRDT_YMD*/
	, FN_CRYPTO_ENC(NVL(G, '-'),'M_KEY')                                                                              /*MBPHNO*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*ZIP*/
	, FN_CRYPTO_ENC(NVL(F, '-'),'M_KEY')                                                                              /*ADDR*/
	, FN_CRYPTO_ENC('-','M_KEY')                                                                                      /*DADDR*/
	, NULL                                                                                                            /*TMPR_STRG_DATA*/
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = Q), '-')                                         /*SPRT_STTS_CD*/
	, NULL                                                                                                            /*RSN*/
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE   /*REG_DT*/
	, SYSDATE   /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EML';

--긴금생계비
DELETE FROM TB_EMLVEX_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 80000 AND 89999;
DELETE FROM TB_EMLVEX_SPRT WHERE SPRT_SN BETWEEN 80000 AND 89999;
INSERT INTO TB_EMLVEX_SPRT (
	SPRT_SN		,
	HANAWON_FNSH_YR		,
	ENTCNY_YMD		,
	HNW_TH		,
	DSCSN_YMD		,
	HANACT_CD		,
	CNSL_FLNM		,
	EML		,
	BACNT_BANK_CD		,
	ACTNO		,
	DPSTR		,
	EXCV_MTHD_CD			,
	EXCV_MTHD_ETC	,
	FRST_CNSL_YMD
)
SELECT
	(B+80000)
	, NVL(J, '-')
	, NVL(I, '-')
	, NVL(K, '-')
	, REPLACE(NVL(N, '19800101'), '-', '')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = L), '-')
	, FN_CRYPTO_ENC(NVL(M, '-'),'M_KEY')
	, FN_CRYPTO_ENC(NVL(H, '-'),'M_KEY')
	, NVL((SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = TRIM(SUBSTR(O, 0, INSTR(O, ' ')-1))), '-')
	, FN_CRYPTO_ENC(NVL(TRIM(SUBSTR(O, INSTR(O, ' ')+1)), '-'),'M_KEY')
	, FN_CRYPTO_ENC(NVL(P, '-'),'M_KEY')
	, '-'
	, ''
	, '19800101'
FROM TB_MIGRATION
WHERE A = 'EML';

--긴급생계비지원현황
DELETE FROM TB_EMLVEX_SPRT_PRCN_MNG WHERE SPRT_SN BETWEEN 80000 AND 89999;
INSERT INTO TB_EMLVEX_SPRT_PRCN_MNG (
	EMLVEX_SPRT_PRCN_MNG_SN		,
	SPRT_SN		,
	SPRT_NMTM		,
	SPRT_AMT		,
	EMRG_SPRT_SPDM_YN		,
	EMRG_SPRT_SPDM_RSN		,
	EMRG_SPRT_SPDM_N_RSN		,
	CYCL		,
	APLY_AMT		,
	APLY_MAIN_CN		,
	MAIN_CRSS_RSN		,
	DSBLTY_YN		,
	EARN_CD		,
	MBOHH_CNT_CD		,
	DWNG_SHAPE_CD		,
	UTBL_NPMNT_CD		,
	CRSS_CD		,
	TOT_SCR		,
	GIVE_YMD		,
	GIVE_AMT		,
	RMRK		,
	RGTR_ID     ,
	MDFR_ID       ,
	REG_DT        ,
	MDFCN_DT        ,
	DEL_YN
)
SELECT
	SEQ_TB_EMLVEX_SPRT_PRCN_MNG.NEXTVAL
	, (B+80000)
	, O
	, P
	, (CASE WHEN Q = 'O' THEN 'Y' WHEN Q = 'X' THEN 'N' ELSE '' END)
	, R
	, '-'	--긴급지원수급사유(무)
	, S
	, U
	, V
	, W
	, (CASE WHEN X = '유' THEN 'Y' WHEN X = '무' THEN 'N' ELSE '' END)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = Y)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = Z)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_A)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_B)
	, (SELECT INDIV_CD FROM TB_CMMN_INDIV_CD WHERE INDIV_CD_NM = A_C)
	, A_D
	, REPLACE(REPLACE(A_E,'-',''),'.','')
	, A_F
	, A_J
	, 'MBR_0000000064'                                                                                                /*RGTR_ID*/
	, 'MBR_0000000064'                                                                                                /*MDFR_ID*/
	, SYSDATE   /*REG_DT*/
	, SYSDATE   /*MDFCN_DT*/
	, 'N'                                                                                                             /*DEL_YN*/
FROM TB_MIGRATION
WHERE A = 'EML_PRC';




/* 하나센터 사용자 마이그레이션
 
delete from TB_MBR_ADTIFM where MBR_ID LIKE 'MBR_0000001%';
delete from JNITCMSMBR where MBR_ID LIKE 'MBR_0000001%';

insert into JNITCMSMBR (MBR_ID, MBR_LOGIN , MBR_NM, PASSWD, TYPE_ID, ORG_ID, ISDEL, EMAIL_RECV, SMS_RECV, PW_MISCNT, CREATED, MODIFIED)
select 
	'MBR_0000001'||LPAD(ROWNUM,3,'0') AS MBR_ID,
	F AS MBR_LOGIN,
	E AS MBR_NM,
	'5E136C244AB6D9E5B8ED74AD0DF5F92A77B6B2553F16EEAC66072ED189894A4' AS PASSWD, --gksktpsxj1!
	30034 AS TYPE_ID,
	(select ORG_ID from JNITCMSORG where REPLACE(B,'(미사용)','') = ORG_NM) AS ORG_ID,
	0 AS ISDEL,
	0 AS EMAIL_RECV,
	0 AS SMS_RECV,
	1 AS PW_MISCNT,
	sysdate, 
	sysdate
from TMP_MBR_MIG WHERE C = '하나센터' ;

insert into TB_MBR_ADTIFM (MBR_ID)
select 
	'MBR_0000001'||LPAD(ROWNUM,3,'0') AS MBR_ID
from TMP_MBR_MIG WHERE C = '하나센터' ;
 */
*/