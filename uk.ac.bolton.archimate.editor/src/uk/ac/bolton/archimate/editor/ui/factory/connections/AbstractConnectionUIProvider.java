/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package uk.ac.bolton.archimate.editor.ui.factory.connections;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

import uk.ac.bolton.archimate.editor.ui.factory.AbstractElementUIProvider;


/**
 * Abstract Connection UI Provider
 * 
 * @author Phillip Beauvoir
 */
public abstract class AbstractConnectionUIProvider extends AbstractElementUIProvider {
    
    @Override
    public Color getDefaultColor() {
        return ColorConstants.black;
    }
}
