<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
        version="2.0"
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:integration="http://spring-integration.codewars.com"
        exclude-result-prefixes="integration"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://spring-integration.codewars.com ">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="integration:application">
        <html>
            <head>
                <title>HTML Result</title>
            </head>
            <body>
                <xsl:variable name="age" select="integration:age/text()"/>
                <h1>Hello
                    <xsl:value-of select="integration:name/text()"/>, your age is
                    <xsl:value-of select="$age"/>
                </h1>
                <xsl:variable name="permission">
                    <xsl:choose>
                        <xsl:when test="$age &gt; 18 or $age = 18">may</xsl:when>
                        <xsl:when test="$age &lt; 18">may not</xsl:when>
                    </xsl:choose>
                </xsl:variable>
                <h3>You
                    <xsl:value-of select="$permission"/> drink alcohol
                </h3>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>