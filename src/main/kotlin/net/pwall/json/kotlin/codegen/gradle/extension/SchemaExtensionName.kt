/*
 * @(#) SchemaExtensionName.kt
 *
 * json-kotlin-gradle  Gradle Code Generation Plugin for JSON Schema
 * Copyright (c) 2021 Peter Wall
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.pwall.json.kotlin.codegen.gradle.extension

import groovy.lang.Closure

import org.gradle.api.Action
import org.gradle.util.ConfigureUtil

class SchemaExtensionName(private val container: SchemaExtensionContainerImpl, private val keyword: String) {

    @Suppress("unused")
    fun formatValidation(closure: Closure<*>): SchemaExtensionFormatValidation {
        return formatValidation(ConfigureUtil.configureUsing(closure))
    }

    @Suppress("unused")
    fun formatValidation(action: Action<in SchemaExtensionFormatValidation>): SchemaExtensionFormatValidation {
        return container.create(SchemaExtensionContainerImpl.generatedName,
                SchemaExtensionFormatValidation::class.java) {
            action.execute(this)
        }
    }

    @Suppress("unused")
    fun formatValidation(value: String, format: String) = formatValidation {
        this.keyword.set(this@SchemaExtensionName.keyword)
        this.value.set(value)
        this.format.set(format)
    }

    @Suppress("unused")
    fun intValidation(closure: Closure<*>): SchemaExtensionIntValidation {
        return intValidation(ConfigureUtil.configureUsing(closure))
    }

    @Suppress("unused")
    fun intValidation(action: Action<in SchemaExtensionIntValidation>): SchemaExtensionIntValidation {
        return container.create(SchemaExtensionContainerImpl.generatedName, SchemaExtensionIntValidation::class.java) {
            action.execute(this)
        }
    }

    @Suppress("unused")
    fun intValidation(value: String, type: String, number: Int) = intValidation {
        this.keyword.set(this@SchemaExtensionName.keyword)
        this.value.set(value)
        this.type.set(type)
        this.number.set(number)
    }

    @Suppress("unused")
    fun patternValidation(closure: Closure<*>): SchemaExtensionPatternValidation {
        return patternValidation(ConfigureUtil.configureUsing(closure))
    }

    @Suppress("unused")
    fun patternValidation(action: Action<in SchemaExtensionPatternValidation>): SchemaExtensionPatternValidation {
        return container.create(SchemaExtensionContainerImpl.generatedName,
                SchemaExtensionPatternValidation::class.java) {
            action.execute(this)
        }
    }

    @Suppress("unused")
    fun patternValidation(value: String, pattern: Regex) = patternValidation {
        this.keyword.set(this@SchemaExtensionName.keyword)
        this.value.set(value)
        this.pattern.set(pattern)
    }

}
