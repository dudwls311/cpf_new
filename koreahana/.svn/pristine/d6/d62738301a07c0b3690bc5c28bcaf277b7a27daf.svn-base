<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%//제출서류폼 %>
<table id="smbFileTrForm" style="display: none;">
	<tr>
		<th>
			@smbsnDocNm@ @@smbsnDocRqrYnForm@@
			@@smbsnDocMtlYnForm@@
			@@smbsnDocFileForm@@
		</th>
		<td id="@prefix@">
			@@smbsnRsnForm@@
			@@smbFileTdForm@@
		</td>
	</tr>
</table>
<div id="smbFileTdForm" style="display: none;">
	<div class="file_multi" id="@subPrefix@Form" data-@prefix@sort="@nextSort@" >
		@@smbsnFileTrgForm@@
		@@myDocBoxForm@@
		<button class="btn_st btn_ico_mn FloatRight" onclick="ComFns.smbsnDocFileDelAct('@prefix@','@subPrefix@', '@docBoxYn@', '@smbsnDocMtlYn@','@smbDocMpngSn@');return false;">제거</button>
		<div id="@subPrefix@Div" style="@display@">
			<div class="MAT10">
				<input type="hidden" name="@prefix@id" value="@subPrefix@" />
				<input type="file" id="@subPrefix@" name="@subPrefix@file" style="display: none" />
				@@smbsnFileForm@@
			</div>
		</div>
	</div>
</div>
<div id="smbsnFileTrgForm" style="display: none;">
	<a class="btn_st" href="#" id="@subPrefix@Trg" data-id="@subPrefix@">파일찾기</a>
</div>
<div id="smbsnDocRqrYnForm" style="display: none;">
	<b class="imp_st">*</b>
</div>
<div id="smbsnDocMtlYnForm" style="display: none;">
	<br><button type="button" class="btn_st btn_ico_pl" style="width: 123px;" onclick="ComFns.smbsnDocFileFormAdd('@prefix@', '@docBoxYn@', '@smbsnDocMtlYn@');return false;">파일추가</button>
</div>
<div id="smbsnDocFileForm" style="display: none;">
	<br /><a class="btn_st btn_c_gy" href="#" style="width: 123px; text-align: center;" onclick="fnDocFormDownload('@smbsnDocFormSn@');return false;">양식 다운로드</a>
</div>
<div id="smbsnRsnForm" style="display: none;">
	<p class="txt_c_bl br">@smbsnRsn@</p>
</div>
<div id="myDocBoxForm" style="display: none;">
	<a class="btn_st btn_c_sc02" href="#" onclick="ComFns.openMyDocBox('@subPrefix@','@smbsnDocMtlYn@', '@smbDocMpngSn@');return false;">나의 문서함</a>
</div>
<div id="smbsnFileForm" style="display: none;">
	<input type="hidden" name="@subPrefix@fsn" value="@atchFileSn@" />
	<input type="hidden" name="@subPrefix@mpngSn" value="@smbDocMpngSn@" />
	<span class="file_uplode">
		<span class="file_name" style="width: 90%;">
			<a href="#" class="txt_ico_f" onclick="fnMyFileDownload('@atchFileSn@')"><span id="@subPrefix@FileNm">@orgnlAtchFileNm@</span></a>
		</span>
	</span>
</div>
<div id="smbsnFileNewForm" style="display: none;">
	<input type="hidden" id="@subPrefix@fsn" name="@subPrefix@fsn" value="" />
	<span class="file_uplode">
		<span class="file_name">
			<span id="@subPrefix@FileNm"></span>
			<a class="file_del" href="#" id="@subPrefix@Delete"><span class="comment">파일제거</span></a>
		</span>
	</span>
</div>