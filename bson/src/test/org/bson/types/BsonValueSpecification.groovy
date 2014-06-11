/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bson.types

import org.bson.BsonInvalidOperationException
import spock.lang.Specification

class BsonValueSpecification extends Specification {
    def 'is methods should return true for the correct type'() {
        expect:
        new BsonNull().isNull()
        new BsonInt32(42).isInt32()
        new BsonInt32(42).isNumber()
        new BsonInt64(52L).isInt64()
        new BsonInt64(52L).isNumber()
        new BsonDouble(62.0).isDouble()
        new BsonDouble(62.0).isNumber()
        new BsonBoolean(true).isBoolean()
        new BsonDateTime(new Date().getTime()).isDateTime()
        new BsonString('the fox ...').isString()
        new Code('int i = 0;').isJavaScript()
        new ObjectId().isObjectId()
        new CodeWithScope('int x = y', new BsonDocument('y', new BsonInt32(1))).isJavaScriptWithScope()
        new RegularExpression('^test.*regex.*xyz$', 'i').isRegularExpression()
        new Symbol('ruby stuff').isSymbol()
        new Timestamp(0x12345678, 5).isTimestamp()
        new Binary((byte) 80, [5, 4, 3, 2, 1] as byte[]).isBinary()
        new DBPointer("ns", new ObjectId()).isDBPointer()
        new BsonArray().isArray()
        new BsonDocument().isDocument()
    }

    def 'is methods should return false for the incorrect type'() {
        expect:
        !new BsonBoolean(false).isNull()
        !new BsonNull().isInt32()
        !new BsonNull().isNumber()
        !new BsonNull().isInt64()
        !new BsonNull().isNumber()
        !new BsonNull().isDouble()
        !new BsonNull().isNumber()
        !new BsonNull().isBoolean()
        !new BsonNull().isDateTime()
        !new BsonNull().isString()
        !new BsonNull().isJavaScript()
        !new BsonNull().isObjectId()
        !new BsonNull().isJavaScriptWithScope()
        !new BsonNull().isRegularExpression()
        !new BsonNull().isSymbol()
        !new BsonNull().isTimestamp()
        !new BsonNull().isBinary()
        !new BsonNull().isDBPointer()
        !new BsonNull().isArray()
        !new BsonNull().isDocument()
    }

    def 'as methods should return false for the incorrect type'() {
        when:
        new BsonNull().asInt32()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asNumber()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asInt64()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asNumber()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asDouble()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asNumber()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asBoolean()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asDateTime()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asString()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asJavaScript()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asObjectId()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asJavaScriptWithScope()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asRegularExpression()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asSymbol()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asTimestamp()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asBinary()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asDBPointer()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asArray()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asDocument()

        then:
        thrown(BsonInvalidOperationException)

        when:
        new BsonNull().asNumber()

        then:
        thrown(BsonInvalidOperationException)
    }
}