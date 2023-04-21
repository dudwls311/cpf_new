<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%//제출서류폼 %>
<table id="smbDocAppend" style="display: none;">
	<tr id="smbDoc@nextSort@" class="smbDoc@nextSort@" data-sort="@nextSort@">
		<th class="AlignCenter" rowspan="4">서류@nextSort@<%-- <button type="button" class="grab_menu"><span class="comment">파일 위치 이동</span> --%></button></th>
		<th><label for="a0001">서류 명</label> <span class="imp_st">*</span></th>
		<td>
			<input type="hidden" name="docId" value="smbDoc@nextSort@" />
			<input type="hidden" name="smbDoc@nextSort@_smbsnDocSn" value="@smbsnDocSn@" />
			<input type="hidden" name="smbDoc@nextSort@_smbsnDocTypeVl" value="@smbDocId@" />
			<input type="text" name="smbDoc@nextSort@_smbsnDocNm" value="@smbsnDocNm@" class="st_input input_long" placeholder="서류 명" />
		</td>
		<th class="AlignCenter" rowspan="4"><a class="btn_st btn_ico_mn" href="#" onclick="fnSmbDocFormDel('smbDoc@nextSort@','@smbsnDocSn@');return false;" >삭제</a></th>
	</tr>
	<tr id="smbDoc@nextSort@_1" class="smbDoc@nextSort@">
		<th><label for="a0002">설명</label></th>
		<td><input type="text" name="smbDoc@nextSort@_smbsnRsn" value="@smbsnRsn@" class="st_input input_long" /></td>
	</tr>
	<tr id="smbDoc@nextSort@_2" class="smbDoc@nextSort@">
		<th>유형</th>
		<td>
			<div class="st_check">
				<input type="checkbox" id="smbDoc@nextSort@_smbsnDocRqrYn" name="smbDoc@nextSort@_smbsnDocRqrYn" value="Y" @smbsndocrqryn@ /><label for="smbDoc@nextSort@_smbsnDocRqrYn">필수 제출서류</label>
				<input type="checkbox" id="smbDoc@nextSort@_smbsnDocMtlYn" name="smbDoc@nextSort@_smbsnDocMtlYn" value="Y" @smbsndocmtlyn@ /><label for="smbDoc@nextSort@_smbsnDocMtlYn">복수등록가능</label>
				<input type="checkbox" id="smbDoc@nextSort@_docBoxYn" name="smbDoc@nextSort@_docBoxYn" value="Y" @docboxyn@ /><label for="smbDoc@nextSort@_docBoxYn">문서함사용</label>
			</div>
		</td>
	</tr>
	<tr id="smbDoc@nextSort@_3" class="smbDoc@nextSort@">
		<th><label for="a0001">서식파일</label></th>
		<td>
			@@smbDocFile@@
		</td>
	</tr>
</table>

<%//제출서류 등록된 첨부파일폼 %>
<div id="smbDocFileAppendExist" style="display: none;">
	<div class="file_multi ig_wrap" id="smbDoc@nextSort@Form">
		<div class="ig_s">
			<a class="btn_st" href="#" id="smbDoc@nextSort@_fileTrg">파일찾기</a>
		</div>
		<div class="ig_l PAL5 PAR5">
			<div id="smbDoc@nextSort@_fileDiv">
				<div class="MAT10">
					<input type="file" id="smbDoc@nextSort@_file" name="smbDoc@nextSort@_file" style="display: none;" />
					<input type="hidden" name="smbDoc@nextSort@_fsn" value="@smbsnDocFormSn@" />
					<span class="file_uplode">
						<span class="file_name">
							<span id="smbDoc@nextSort@_fileFileNm"><a href="#" onclick="fnDocFormDownload('@smbsnDocSn@','@pbancrcSn@','@smbsnDocFormSn@');return false;">@orgnlAtchFileNm@</a></span>
							<a class="file_del" href="#" id="smbDoc@nextSort@_fileDelete" onclick="fnDocFormDelAct('@nextSort@','@smbsnDocFormSn@');return false;"><span class="comment">파일제거</span></a>
						</span>
					</span>
				</div>
			</div>
		</div>
	</div>
	
</div>

<%//제출서류 신규 첨부파일폼 %>
<div id="smbDocFileAppendNew" style="display: none;">
	<div class="file_multi ig_wrap" id="smbDoc@nextSort@Form">
		<div class="ig_s">
			<a class="btn_st" href="#" id="smbDoc@nextSort@_fileTrg">파일찾기</a>
		</div>
		<div class="ig_l PAL5 PAR5">
			<div id="smbDoc@nextSort@_fileDiv">
				<input type="file" id="smbDoc@nextSort@_file" name="smbDoc@nextSort@_file" style="display: none;" />
				<span class="file_uplode">
					<span class="file_name">
						<span id="smbDoc@nextSort@_fileFileNm"></span>
						<a class="file_del" href="#" id="smbDoc@nextSort@_fileDelete"><span class="comment">파일제거</span></a>
					</span>
				</span>
			</div>
		</div>
	</div>
</div>

<%//모집공고 첨부파일폼 %>
<div id="pbaFileAppend" style="display: none;">
	<div class="file_multi ig_wrap" id="@fileId@Form" data-@type@sort="@nextSort@" >
		<div class="ig_s">
			<a class="btn_st" href="#" id="@fileId@Trg">파일찾기</a>
		</div>
		<div class="ig_l PAL5 PAR5">
			<div id="@fileId@Div">
				<input type="file" id="@fileId@" name="@fileId@" style="display: none;" />
				<span class="file_uplode">
					<span class="file_name">
						<span id="@fileId@FileNm"></span>
						<a class="file_del" href="#" id="@fileId@Delete"><span class="comment">파일제거</span></a>
					</span>
				</span>
			</div>
		</div>
		<div class="ig_s">
			<button class="btn_st btn_ico_mn" onclick="fnFileFormDel('@fileId@');return false;">제거</button>
		</div>
	</div>
</div>