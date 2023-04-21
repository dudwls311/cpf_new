CREATE OR REPLACE VIEW VW_SPRT_HISTORY
AS
	/*지원이력조회 VIEW*/
SELECT
	a.PBANCRC_CTGRY_FRST_CD
	, a.SPRT_SN
	, a.FLNM
	, a.BRDT_YMD
	, (CASE WHEN a.ENTCNY_YMD IS NULL THEN ma.ENTCNY_YMD ELSE a.ENTCNY_YMD END)			ENTCNY_YMD
	, (CASE WHEN a.PRTDCS_YMD IS NULL THEN ma.PRTDCS_YMD ELSE a.PRTDCS_YMD END)			PRTDCS_YMD
	, ma.HANAWON_TH
	, ma.HANAWON_FNSH_YMD
	, ma.NTKRDF_UNQ_NO
	, a.REG_DT
	, a.RGTR_ID
	, a.GIVE_YMD
FROM (
	select	/* 의료비 */
		/*지원유형+지원사업명	*/	'20001' /*'MDL'*/	PBANCRC_CTGRY_FRST_CD
		/*지원일련번호		*/	, MDLCR_SPRT_SN	SPRT_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, BRDT_YMD						
		/*입국일			*/ 	, ENTCNY_YM			ENTCNY_YMD
		/*보호결정일		*/ 	, NULL				PRTDCS_YMD
		/*신청일			*/	, NULL				REG_DT
		/*지급결정일		*/	, SPRT_YMD			GIVE_YMD
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(상담사)	*/	, NULL				RGTR_ID
	from
		TB_MDLCR_SPRT ms
		WHERE DEL_YN = 'N'

	UNION ALL
	
	select	/* 긴급생계비 */
		/*지원유형+지원사업명	*/	'10001' /*'EML'*/
		/*지원일련번호		*/	, s.SPRT_SN
		/*성명			*/ 	, s.FLNM
		/*생년월일			*/ 	, s.BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, s.REG_DT
		/*지급결정일		*/	, espm.GIVE_YMD
		/*선정결과			*/	, s.SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_EMLVEX_SPRT es
		LEFT JOIN TB_EMLVEX_SPRT_PRCN_MNG espm ON (espm.SPRT_SN = es.SPRT_SN AND espm.DEL_YN = 'N')
		INNER JOIN TB_SPRT s ON (s.SPRT_SN = es.SPRT_SN AND s.DEL_YN = 'N')
		INNER JOIN TB_PBANCRC p ON (s.PBANCRC_SN = p.PBANCRC_SN AND p.DEL_YN = 'N')
		
	UNION ALL
	
	select	/* 가산금지원 */
		/*지원유형+지원사업명	*/	'10002' /*'ADT'*/
		/*지원일련번호		*/	, s.SPRT_SN
		/*성명			*/ 	, s.FLNM
		/*생년월일			*/ 	, s.BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, s.REG_DT
		/*지급결정일		*/	, aaspm.GIVE_DCSN_YMD
		/*선정결과			*/	, s.SPRT_STTS_CD
		/*작성자			*/	, s.RGTR_ID
	from
		TB_ADTN_AMT_SPRT aas
		LEFT JOIN TB_ADTN_AMT_SPRT_PRCN_MNG aaspm  ON (aaspm.SPRT_SN = aas.SPRT_SN AND aaspm.DEL_YN = 'N')
		INNER JOIN TB_SPRT s ON (s.SPRT_SN = aas.SPRT_SN AND s.DEL_YN = 'N')
		INNER JOIN TB_PBANCRC p ON (s.PBANCRC_SN = p.PBANCRC_SN AND p.DEL_YN = 'N')

	UNION ALL
	
	select	/* 장학금 */
		/*지원유형+지원사업명	*/	'10003' /*'SHO'*/
		/*지원일련번호		*/	, s.SPRT_SN
		/*성명			*/ 	, s.FLNM
		/*생년월일			*/ 	, s.BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, s.REG_DT
		/*지급결정일		*/	, sspm.GIVE_YMD
		/*선정결과			*/	, s.SPRT_STTS_CD
		/*작성자			*/	, s.RGTR_ID
	from
		TB_SHOL_SPRT ss
		LEFT JOIN TB_SHOL_SPRT_PRCN_MNG sspm  ON (sspm.SPRT_SN = ss.SPRT_SN AND sspm.DEL_YN = 'N')
		INNER JOIN TB_SPRT s ON (s.SPRT_SN = ss.SPRT_SN AND s.DEL_YN = 'N')
		INNER JOIN TB_PBANCRC p ON (s.PBANCRC_SN = p.PBANCRC_SN AND p.DEL_YN = 'N')
		
	UNION ALL
	
	select	/* 교육지원금 */
		/*지원유형+지원사업명	*/	'10004' /*'EDU'*/
		/*지원일련번호		*/	, s.SPRT_SN
		/*성명			*/ 	, s.FLNM
		/*생년월일			*/ 	, s.BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, s.REG_DT
		/*지급결정일		*/	, espm.GIVE_YMD
		/*선정결과			*/	, s.SPRT_STTS_CD
		/*작성자			*/	, s.RGTR_ID
	from
		TB_EDU_SPRT es
		LEFT JOIN TB_EDU_SPRT_PRCN_MNG espm  ON (espm.SPRT_SN = es.SPRT_SN AND espm.DEL_YN = 'N')
		INNER JOIN TB_SPRT s ON (s.SPRT_SN = es.SPRT_SN AND s.DEL_YN = 'N')
		INNER JOIN TB_PBANCRC p ON (s.PBANCRC_SN = p.PBANCRC_SN AND p.DEL_YN = 'N')
		
	UNION ALL
	
	select	/* 미래행복통장신규신청 */
		/*지원유형+지원사업명	*/	'20003' /*'FTH_NEW'*/
		/*지원일련번호		*/	, FTHPBB_NEW_APLY_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, NULL
		/*입국일			*/ 	, ENTCNY_YMD
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, TO_DATE(RCPT_YMD, 'YYYY-MM-DD')
		/*지급결정일		*/	, BB_JOIN_YMD
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_FTHPBB_NEW_APLY
	WHERE
		DEL_YN = 'N'
		
	UNION ALL
	
	select	/* 미래행복통장만기해지 */
		/*지원유형+지원사업명	*/	'20004' /*'FTH_MTR'*/
		/*지원일련번호		*/	, FTHPBB_MTRY_CNCLTN_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, NULL
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, TO_DATE(RCPT_YMD, 'YYYY-MM-DD')
		/*지급결정일		*/	, BB_JOIN_YMD
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_FTHPBB_MTRY_CNCLTN
	WHERE
		DEL_YN = 'N'
		
	UNION ALL
	
	select	/* 미래행복통장중도해지 */
		/*지원유형+지원사업명	*/	'20005' /*'FTH_MTR'*/
		/*지원일련번호		*/	, FTHPBB_MDW_CNCLTN_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, NULL
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, TO_DATE(RCPT_YMD, 'YYYY-MM-DD')
		/*지급결정일		*/	, BB_JOIN_YMD
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_FTHPBB_MDW_CNCLTN
	WHERE
		DEL_YN = 'N'
		
	UNION ALL
	
	select	/* 경영개선자금지원 */
		/*지원유형+지원사업명	*/	'20006' /*'MGM'*/
		/*지원일련번호		*/	, MGMIPV_AMT_SPRT_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, NULL
		/*지급결정일		*/	, SPRT_YR
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_MGMIPV_AMT_SPRT
	WHERE
		DEL_YN = 'N'
		
	UNION ALL
	
	select	/* 영농정착지원 */
		/*지원유형+지원사업명	*/	'20007' /*'FRM'*/
		/*지원일련번호		*/	, FRM_SPFST_SN
		/*성명			*/ 	, FLNM
		/*생년월일			*/ 	, BRDT_YMD
		/*입국일			*/ 	, ENTCNY_YMD
		/*보호결정일		*/ 	, PRTDCS_YMD
		/*신청일			*/	, NULL
		/*지급결정일		*/	, SPRT_YR
		/*선정결과			*/	, SPRT_STTS_CD
		/*작성자(담당자)	*/	, NULL
	from
		TB_FRM_SPFST
	WHERE
		DEL_YN = 'N'
		
	UNION ALL
	
	select	/* 화상영어 + 학습지 + 정착지원전문관리사 + 취업바우처카드 + 취업연계직업훈련 */
		/*지원유형+지원사업명	*/	p.PBANCRC_CTGRY_FRST_CD
		/*지원일련번호		*/	, s.SPRT_SN
		/*성명			*/ 	, s.FLNM
		/*생년월일			*/ 	, s.BRDT_YMD
		/*입국일			*/ 	, NULL
		/*보호결정일		*/ 	, NULL
		/*신청일			*/	, s.REG_DT
		/*지급결정일		*/	, NULL
		/*선정결과			*/	, s.SPRT_STTS_CD
		/*작성자			*/	, s.RGTR_ID
	from
		TB_SPRT s
		INNER JOIN TB_PBANCRC p ON (s.PBANCRC_SN = p.PBANCRC_SN AND p.DEL_YN = 'N' AND p.PBANCRC_CTGRY_FRST_CD IN ('10005','10006','10007','10008','10009'))
	where
		s.DEL_YN = 'N'
) a
LEFT JOIN TB_MBR_ADTIFM ma ON (a.RGTR_ID = ma.MBR_ID)
WHERE a.SPRT_STTS_CD = '16002'		/*선정된 데이터만 조회*/