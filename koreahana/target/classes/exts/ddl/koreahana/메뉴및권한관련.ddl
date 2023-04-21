DELETE FROM TB_MENU_M;

INSERT INTO TB_MENU_M(MENU_SN,UPR_MENU_SN,MENU_URL,MENU_NM,MENU_SEQ,MENU_LVL_VL,MENU_EXPLNT,REG_DT,RGTR_ID,MDFCN_DT,MDFR_ID,DEL_YN) VALUES 
('1000000','0','/exts/index.do','사업공고(신청서) 관리','1','1','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1010000','1000000','/exts/koreahana/pba/emeIndex.do','긴급생계비','1','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1020000','1000000','/exts/koreahana/pba/adtIndex.do','가산금','2','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1030000','1000000','/exts/koreahana/pba/shoIndex.do','장학금','3','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1040000','1000000','/exts/koreahana/pba/eduIndex.do','교육지원금','4','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1050000','1000000','/exts/koreahana/pba/vdoIndex.do','화상영어','5','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1060000','1000000','/exts/koreahana/pba/lnbIndex.do','학습지','6','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1070000','1000000','/exts/koreahana/pba/spfIndex.do','정착지원 전문관리사','7','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1080000','1000000','/exts/koreahana/pba/emvIndex.do','취업바우처카드','8','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('1090000','1000000','/exts/koreahana/pba/empIndex.do','취업연계 직업훈련','9','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2000000','0','/exts/koreahana/mdl/index.do','지원대상 관리','2','1','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2010000','2000000','/exts/koreahana/mdl/index.do','의료비','1','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2010100','2010000','/exts/koreahana/mdl/index.do','지원금 지급정보','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2010200','2010000','/exts/koreahana/mdl/statistic.do','통계','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2020000','2000000','/exts/koreahana/eml/index.do','긴급생계비','2','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2020100','2020000','/exts/koreahana/eml/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2020200','2020000','/exts/koreahana/emlPrc/index.do','지원금 지급정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2020300','2020000','/exts/koreahana/emlPrc/statistic.do','통계','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2030000','2000000','/exts/koreahana/adt/index.do','가산금','3','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2030100','2030000','/exts/koreahana/adt/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2030200','2030000','/exts/koreahana/adtPrc/index.do','지원금 지급정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2030300','2030000','/exts/koreahana/adtPrc/statistic.do','통계','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2040000','2000000','/exts/koreahana/sho/index.do','장학금','4','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2040100','2040000','/exts/koreahana/sho/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2040200','2040000','/exts/koreahana/shoPrc/index.do','장학금 지급정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2040300','2040000','/exts/koreahana/shoPrc/statistic.do','통계','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2050000','2000000','/exts/koreahana/edu/index.do','교육지원금','5','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2050100','2050000','/exts/koreahana/edu/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2050200','2050000','/exts/koreahana/eduPrc/index.do','지원금 지급정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2060000','2000000','/exts/koreahana/vdo/index.do','화상영어','6','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2060100','2060000','/exts/koreahana/vdo/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2060200','2060000','/exts/koreahana/vdoPrc/index.do','화상영어 지원정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2070000','2000000','/exts/koreahana/lnb/index.do','학습지','7','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2070100','2070000','/exts/koreahana/lnb/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2070200','2070000','/exts/koreahana/lnbPrc/index.do','학습지 지원정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2080000','2000000','/exts/koreahana/spf/index.do','정착지원 전문관리사','8','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2080100','2080000','/exts/koreahana/spf/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2080200','2080000','/exts/koreahana/spfPrc/index.do','교육 지원정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2090000','2000000','/exts/koreahana/emv/index.do','취업바우처카드','9','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2090100','2090000','/exts/koreahana/emv/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2090200','2090000','/exts/koreahana/emvPrc/index.do','지원금 지급정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2090300','2090000','/exts/koreahana/emvUse/index.do','카드사용 정보','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2100000','2000000','/exts/koreahana/fthNew/index.do','미래행복통장','10','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2100100','2100000','/exts/koreahana/fthNew/index.do','신규신청','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2100200','2100000','/exts/koreahana/fthMtr/index.do','만기해지','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2100300','2100000','/exts/koreahana/fthMdw/index.do','중도해지','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2100400','2100000','/exts/koreahana/fthStt/index.do','통계','4','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2110000','2000000','/exts/koreahana/emp/index.do','취업연계 직업훈련','11','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2110100','2110000','/exts/koreahana/emp/index.do','신청서 접수현황','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2110200','2110000','/exts/koreahana/empPrc/index.do','교육 지원정보','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2110300','2110000','/exts/koreahana/empPrc/statistic.do','통계','3','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2120000','2000000','/exts/koreahana/mgm/index.do','경영개선자금','12','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2120100','2120000','/exts/koreahana/mgm/index.do','지원금 지급정보','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2120200','2120000','/exts/koreahana/mgm/statistic.do','통계','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('2130000','2000000','/exts/koreahana/frm/index.do','영농정착','13','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2130100','2130000','/exts/koreahana/frm/index.do','지원금 지급정보','1','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('2130200','2130000','/exts/koreahana/frm/statistic.do','통계','2','3','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('3000000','0','/exts/koreahana/spr/index.do','지원이력 조회','3','1','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('3010000','3000000','/exts/koreahana/spr/index.do','지원이력조회','1','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),

('4000000','0','/exts/index.do','설정','4','1','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('4010000','4000000','/exts/koreahana/spb/index.do','지원사업설정','1','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('4020000','4000000','/exts/com/mbr/index.do','사용자관리','2','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('4030000','4000000','/exts/com/grpMenuAuth/index.do','그룹별 메뉴권한 관리','3','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N'),
('4040000','4000000','/exts/com/indvlzMenuAuth/index.do','개인별 메뉴권한 관리','4','2','',SYSDATE,'SYSTEM',SYSDATE,'SYSTEM','N')
;

DELETE FROM TB_GRP_MENU_AUTH_R;
INSERT INTO TB_GRP_MENU_AUTH_R SELECT '30020', MENU_SN, 'Y', 'Y', 'Y', 'Y', SYSDATE, 'SYSTEM' FROM TB_MENU_M WHERE DEL_YN = 'N'  ORDER BY MENU_LVL_VL, MENU_SEQ;
INSERT INTO TB_GRP_MENU_AUTH_R SELECT '30033', MENU_SN, 'Y', 'Y', 'Y', 'Y', SYSDATE, 'SYSTEM' FROM TB_MENU_M WHERE DEL_YN = 'N' AND MENU_SN IN ('3000000','3010000')  ORDER BY MENU_LVL_VL, MENU_SEQ;
INSERT INTO TB_GRP_MENU_AUTH_R SELECT '30034', MENU_SN, 'Y', 'Y', 'Y', 'Y', SYSDATE, 'SYSTEM' FROM TB_MENU_M WHERE DEL_YN = 'N' AND MENU_SN IN ('3000000','3010000') ORDER BY MENU_LVL_VL, MENU_SEQ;

/*
-- 자립지원부
INSERT INTO TB_INDVLZ_MENU_AUTH_R (MBR_ID,AUTH_GRP_ID,MENU_SN,STRE_AUTH_YN,REDNG_AUTH_YN,DEL_AUTH_YN,PRNTG_AUTH_YN,REG_DT,RGTR_ID) VALUES
('-mbrid-','NONE',1000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',1080000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',1090000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2090000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2090100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2090200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2090300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2100000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2100100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2100200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2100300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2100400,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2110000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2110100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2110200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2110300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2120000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2120100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2120200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2130000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2130100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',2130200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',3000000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('-mbrid-','NONE',3010000,null,'Y',null,null,SYSDATE,'MBR_0000000001');

-- 교육지원부
INSERT INTO TB_INDVLZ_MENU_AUTH_R (MBR_ID,AUTH_GRP_ID,MENU_SN,STRE_AUTH_YN,REDNG_AUTH_YN,DEL_AUTH_YN,PRNTG_AUTH_YN,REG_DT,RGTR_ID) VALUES
('--mbrId--','NONE',1000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1030000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1040000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1050000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1060000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1070000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2040000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2040100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2040200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2040300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2050000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2050100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2050200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2060000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2060100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2060200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2070000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2070100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2070200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2080000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2080100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2080200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',3000000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',3010000,null,'Y',null,null,SYSDATE,'MBR_0000000001');

-- 생활안전부
INSERT INTO TB_INDVLZ_MENU_AUTH_R (MBR_ID,AUTH_GRP_ID,MENU_SN,STRE_AUTH_YN,REDNG_AUTH_YN,DEL_AUTH_YN,PRNTG_AUTH_YN,REG_DT,RGTR_ID) VALUES
('--mbrId--','NONE',1000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1010000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1020000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1030000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1040000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1050000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1060000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1070000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1080000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',1090000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2000000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2010000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2010100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2010200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2020000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2020100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2020200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2020300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2030000,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2030100,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2030200,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',2030300,'Y','Y','Y','Y',SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',3000000,null,'Y',null,null,SYSDATE,'MBR_0000000001'),
('--mbrId--','NONE',3010000,null,'Y',null,null,SYSDATE,'MBR_0000000001');
*/