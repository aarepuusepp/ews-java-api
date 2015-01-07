/**************************************************************************
 Exchange Web Services Java API
 Copyright (c) Microsoft Corporation
 All rights reserved.
 MIT License
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the ""Software""), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 **************************************************************************/

package microsoft.exchange.webservices.data;

import java.util.EnumSet;

/**
 * Represents byte array property definition.
 */
final class ByteArrayPropertyDefinition extends TypedPropertyDefinition {

  /**
   * Initializes a new instance.
   *
   * @param xmlElementName Name of the XML element.
   * @param uri            The URI.
   * @param flags          The flags.
   * @param version        The version.
   */
  protected ByteArrayPropertyDefinition(String xmlElementName, String uri,
      EnumSet<PropertyDefinitionFlags> flags, ExchangeVersion version) {
    super(xmlElementName, uri, flags, version);
  }

  /**
   * Parses the specified value.
   *
   * @param value accepts String
   * @return value
   */
  @Override
  protected Object parse(String value) {
    return Base64EncoderStream.decode(value);
    // return null;
  }

  /**
   * Converts byte array property to a string.
   *
   * @param value accepts Object
   * @return value
   */
  @Override
  protected String toString(Object value) {
    return Base64EncoderStream.encode((byte[]) value);
  }

  /**
   * Gets a value indicating whether this property definition is for a
   * nullable type (ref, int?, bool?...).
   *
   * @return True
   */
  @Override
  protected boolean isNullable() {
    return true;
  }

  /**
   * Gets the property type.
   */
  @Override
  public Class<Byte> getType() {
    return Byte.class;
  }

}
