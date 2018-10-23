<?xml version="1.0" encoding="UTF-8"?>
<Content>
	<Version><![CDATA[${CONTENT.Version!''}]]></Version>
	<AssetID><![CDATA[${CONTENT.AssetID!''}]]></AssetID>
	<ContentID><![CDATA[${CONTENT.ContentID!''}]]></ContentID>
	<Name><![CDATA[${CONTENT.Name!''}]]></Name>
	<ShortName><![CDATA[${CONTENT.ShortName!''}]]></ShortName>
	<CDuration>0</CDuration>
	<DisPlayFileLists>
	<Keywords>
	<#if CONTENT.Keywords?? >
		<#list CONTENT.Keywords as kw> 
		<Keyword>
			<KeywordName><![CDATA[${kw.KeywordName!''}]]></KeywordName>
			<PrimaryKey><![CDATA[${kw.PrimaryKey!''}]]></PrimaryKey>
		</Keyword>
		</#list>
	</#if>
	</Keywords>
	<CopyRight>
		<Area><![CDATA[${CONTENT.CopyRight.Area!''}]]></Area>
	</CopyRight>
</Content>