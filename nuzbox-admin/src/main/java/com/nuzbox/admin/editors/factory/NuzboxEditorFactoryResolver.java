package com.nuzbox.admin.editors.factory;

import com.nuzbox.admin.ApplicationContextProvider;
import com.nuzbox.model.BaseModel;
import com.nuzbox.model.CronJob;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Jamesjohnstone on 08/05/15.
 */
public class NuzboxEditorFactoryResolver {
    private static final Logger LOG = Logger.getLogger(NuzboxEditorFactoryResolver.class);

    public static  NuzboxEditorFactory resolveFactoryForItem(BaseModel item) {
        Class itemType = item.getClass();
        Map<Class, Class> editorFactoryMap = (Map<Class, Class>) ApplicationContextProvider.getApplicationContext().getBean("editorFactoryMap");
        if (editorFactoryMap == null) {
            LOG.error("editorFactoryMap is null");
            return null;
        }

        Class factoryClass = editorFactoryMap.get(itemType);
        Constructor factoryConstructor = null;
        try {
            factoryConstructor = factoryClass.getConstructor(itemType);
        } catch (NoSuchMethodException e) {
            LOG.error(e);
        }

        NuzboxEditorFactory factory = null;

        try {
            if (factoryConstructor != null) {
                factory = (NuzboxEditorFactory) factoryConstructor.newInstance(item);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
